package id.xhydracore.orfez.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.xhydracore.orfez.ui.alat.AlatScreen
import id.xhydracore.orfez.ui.home.HomeScreen
import id.xhydracore.orfez.ui.maintenance.MaintenanceScreen
import id.xhydracore.orfez.ui.splash.SplashScreen
import id.xhydracore.orfez.ui.tutorial.TutorialScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Alat.route) {
            AlatScreen(navController = navController)
        }
        composable(route = Screen.Tutorial.route) {
            TutorialScreen(navController = navController)
        }
        composable(route = Screen.Maintenance.route) {
            MaintenanceScreen(navController = navController)
        }
    }
}