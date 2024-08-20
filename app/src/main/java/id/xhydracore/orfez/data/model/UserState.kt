package id.xhydracore.orfez.data.model

sealed class UserState<out T> {
    object Loading : UserState<Nothing>()
    data class Success<out T>(val data: T) : UserState<T>()
    data class Error(val message: String) : UserState<Nothing>()
}