package id.xhydracore.orfez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import id.xhydracore.orfez.navigation.SetupNavGraph
import id.xhydracore.orfez.ui.theme.ORFEZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ORFEZTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
        actionBar?.hide()
    }
}
