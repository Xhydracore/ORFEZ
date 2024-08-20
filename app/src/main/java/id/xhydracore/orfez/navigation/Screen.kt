package id.xhydracore.orfez.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Alat : Screen("alat_screen")
    object Tutorial : Screen("tutorial_screen")
    object Maintenance : Screen("maintenance_screen")
}