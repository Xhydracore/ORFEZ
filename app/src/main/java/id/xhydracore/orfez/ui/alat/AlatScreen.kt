package id.xhydracore.orfez.ui.alat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import id.xhydracore.orfez.R
import id.xhydracore.orfez.data.model.Parameter
import id.xhydracore.orfez.data.model.UserState
import id.xhydracore.orfez.data.model.WorkManager
import id.xhydracore.orfez.data.network.SupabaseViewModel
import id.xhydracore.orfez.navigation.Screen
import io.github.jan.supabase.annotations.SupabaseExperimental


val gradient180 = Brush.linearGradient(
    colors = listOf(Color("#F6A709".toColorInt()), Color("#12AC78".toColorInt())),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(0f, 0f)
)

@OptIn(SupabaseExperimental::class)
@Composable
fun AlatScreen(viewModel: SupabaseViewModel = viewModel(), navController: NavHostController) {
    val parameterState by viewModel.parameterState


    val workManagerState by viewModel.workManagerState
    var currentWorkManagerState by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.realtimeParameter(this)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        when (parameterState) {
            is UserState.Error -> {
                val message = (parameterState as UserState.Error).message
                Text(text = message)
            }

            is UserState.Loading -> {

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(28.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    colors = CardDefaults.cardColors(Color.Gray)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(gradient180)
                    ) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(start = 8.dp, top = 20.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Loading...",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                fontSize = 24.sp,
                                style = MaterialTheme.typography.headlineMedium
                            )
                        }
                    }
                }
            }

            is UserState.Success -> {
                val data = (parameterState as UserState.Success<Parameter>).data
                CardAlat(data = data, navController)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (workManagerState) {
            is UserState.Error -> {
                val message = (workManagerState as UserState.Error).message
                currentWorkManagerState = message
            }

            UserState.Loading -> {
            }

            is UserState.Success -> {
                val message = (workManagerState as UserState.Success<String>).data
                currentWorkManagerState = message
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .padding(start = 16.dp)
                .height(36.dp)
                .width(100.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gradient180)
            ) {
                Text(
                    text = "ALAT",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
            }

        }

        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_alat_orfez),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(2.dp)
            )
            Column(Modifier.padding(8.dp)) {
                Card {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .background(gradient180)
                    ) {
                        Text(
                            text = "Organic Fertilizer",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(gradient180)
                    ) {
                        Text(
                            text = "Deskripsi",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }


        Text(text = currentWorkManagerState)

        Spacer(modifier = Modifier.height(16.dp))

        CounterButton(viewModel)
    }
}

@Composable
fun CounterButton(viewModel: SupabaseViewModel) {
    var days by remember { mutableStateOf(0) }
    Row(Modifier.padding(8.dp)) {
        Card(
            Modifier
                .size(120.dp)
                .padding(2.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painterResource(id = R.drawable.background_grad),
                        contentScale = ContentScale.Crop
                    )
            ) {
                Column(Modifier.align(Alignment.Center)) {
                    Text(
                        text = days.toString(),
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "hari",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Card {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .background(gradient180)
                ) {
                    Text(
                        text = "Waktu Fermentasi",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                OutlinedButton(onClick = { days-- }) {
                    Text(text = "-")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {
                    viewModel.saveWork(days)

                }) {
                    Text(text = "Atur Waktu")
                }

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedButton(onClick = { days++ }) {
                    Text(text = "+")
                }
            }
        }
    }

}

@Composable
fun CardAlat(data: Parameter, navController: NavHostController) {
    val gradient45 = Brush.linearGradient(
        colors = listOf(Color("#F6A709".toColorInt()), Color("#12AC78".toColorInt())),
        start = Offset(0f, Float.POSITIVE_INFINITY),
        end = Offset(0f, 0f)
    )
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(28.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .clickable(enabled = true) {}
    ) {
        Box(
            modifier = Modifier
                .background(gradient45)
                .fillMaxSize()
        ) {
            IconButton(
                onClick = { navController.navigate(Screen.Home.route) },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 8.dp, top = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .height(120.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_splash),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(top = 16.dp)
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                    )
                    Column {
                        Text(
                            text = "Muhammad Mabrur",
                            Modifier
                                .padding(top = 36.dp, start = 12.dp)
                                .align(Alignment.Start),
                            fontSize = 24.sp,
                            style = MaterialTheme.typography.headlineMedium, color = Color.White
                        )
                        Text(
                            text = "Candimulyo 29\u2103",
                            modifier = Modifier.padding(top = 4.dp, start = 12.dp),
                            color = Color.White
                        )

                    }
                }
                Row(
                    Modifier.align(Alignment.CenterHorizontally),
                ) {
                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(110.dp),
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Text(
                            text = "Temperature",
                            Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = data.temperature.toString() + " \u2103",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(110.dp),
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Text(
                            text = "Humidity",
                            Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "${data.humidity.toString()} %",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(110.dp),
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Text(
                            text = "pH",
                            Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = data.pH.toString(),
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun DisplayParameterDataPreview() {
//    val mockData = Parameter(
//        temperature = 25.99f,
//        humidity = 60.99f,
//        pH = 7.0f
//    )
//    CardAlat(data = mockData)
//}