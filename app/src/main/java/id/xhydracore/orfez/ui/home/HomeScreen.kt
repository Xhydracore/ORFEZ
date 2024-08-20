package id.xhydracore.orfez.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import id.xhydracore.orfez.R
import id.xhydracore.orfez.navigation.Screen
import id.xhydracore.orfez.ui.theme.ORFEZTheme
import id.xhydracore.orfez.ui.utils.DevicePreviews

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardProfile()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.alat),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clickable { navController.navigate(Screen.Alat.route) }
                )

                Text(text = "Alat", textAlign = TextAlign.Center)

            }
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tutorial),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clickable { navController.navigate(Screen.Tutorial.route) }
                )
                Text(text = "Penggunaan Alat")

            }
        }
        Image(
            painter = painterResource(id = R.drawable.maintenance),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clickable { navController.navigate(Screen.Maintenance.route) }
        )
        Text(text = "Keamanan dan Perawatan", textAlign = TextAlign.Center)

    }


}

@Composable
fun CardProfile() {
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
            Text(
                text = "Hi,  Selamat Datang di Orfez!",
                modifier = Modifier
                    .padding(top = 32.dp, start = 16.dp, bottom = 4.dp)
                    .align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                contentScale = ContentScale.None,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.Center),
            )
            Text(
                text = "Muhammad Mabrur",
                Modifier
                    .padding(42.dp)
                    .align(Alignment.BottomCenter),
                textAlign = TextAlign.Center, fontSize = 24.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp), horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Text(text = "Candimulyo 29\u2103", modifier = Modifier.padding(top = 4.dp))

            }
        }

    }
}

//@DevicePreviews
//@Composable
//fun HomeScreenPreview() {
//    ORFEZTheme {
//        HomeScreen()
//    }
//}