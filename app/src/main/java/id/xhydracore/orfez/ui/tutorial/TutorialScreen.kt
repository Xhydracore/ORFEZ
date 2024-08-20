package id.xhydracore.orfez.ui.tutorial

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import id.xhydracore.orfez.R

val gradient180 = Brush.linearGradient(
    colors = listOf(Color("#F6A709".toColorInt()), Color("#12AC78".toColorInt())),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(0f, 0f)
)

@Composable
fun TutorialScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {
        CardProfile(navController)
        CardTutorial()
    }

}

@Composable
fun CardProfile(navController:NavHostController) {
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
            .clickable(enabled = true) {},
        colors = CardDefaults.cardColors(Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .background(gradient45)
                .fillMaxSize()
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
                Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(top = 42.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_alat_tutorial),
                    contentScale = ContentScale.None,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.CenterHorizontally),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier
                        .height(42.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(Color("#00BF63".toColorInt()))
                ) {
                    Text(
                        text = "PENGGUNAAN ALAT",
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp),
                        textAlign = TextAlign.Center, fontSize = 24.sp
                    )
                }
            }

        }

    }
}

@Composable
fun CardTutorial() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.indikator_alat),
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
                            text = "Langkah-langkah",
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
                            text = "Indikator Alat",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.tutorial_alat),
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
                            text = "Video Tutorial",
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
                            text = "Video Tutorial penggunaan alat",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(4.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}