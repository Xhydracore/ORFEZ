package id.xhydracore.orfez.data.network

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.xhydracore.orfez.data.model.Parameter
import id.xhydracore.orfez.data.model.UserState
import id.xhydracore.orfez.data.model.WorkManager
import id.xhydracore.orfez.data.network.SupabaseClient.client
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.channel
import io.github.jan.supabase.realtime.postgresChangeFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class SupabaseViewModel : ViewModel() {
    private val _parameterState = mutableStateOf<UserState<Parameter>>(UserState.Loading)
    val parameterState: State<UserState<Parameter>> = _parameterState

    private val _workManagerState = mutableStateOf<UserState<String>>(UserState.Loading)
    val workManagerState: State<UserState<String>> = _workManagerState

    fun saveWork(days: Int) {
        viewModelScope.launch {
            try {
                _workManagerState.value = UserState.Loading
                client.postgrest["work_manager"].insert(
                    WorkManager(
                        timeSpanDay = days
                    )
                )
                _workManagerState.value = UserState.Success("Setting new Job successfully for $days days!")
            } catch (e: Exception) {
                _workManagerState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }

    fun realtimeParameter(scope: CoroutineScope) {
        viewModelScope.launch {
            try {
                _parameterState.value = UserState.Loading
                val channel = client.channel("maintable")
                val changeFlow =
                    channel.postgresChangeFlow<PostgresAction.Insert>(schema = "public") {
                        table = "maintable"
                    }
                //Collect the flow
                changeFlow.onEach {
                    val stringifiedData = it.record.toString()
                    val data = Json.decodeFromString<Parameter>(stringifiedData)
                    _parameterState.value = UserState.Success(data)
                }.launchIn(scope)
                channel.subscribe()
            } catch (e: Exception) {
                _parameterState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }

}