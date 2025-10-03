package mvp.redflag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mvp.redflag.ui.HomeScreen
import mvp.redflag.ui.PeopleScreen
import mvp.redflag.ui.StageScreen
import mvp.redflag.ui.ToolkitScreen
import mvp.redflag.ui.theme.RedFlagTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RedFlagTheme {
                val nav = rememberNavController()

                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = nav,
                        startDestination = "home"
                    ) {
                        composable(route = "home") {
                            HomeScreen(
                                onPlaybook = { nav.navigate("stage") },
                                onToolkit  = { nav.navigate("toolkit") },
                                onPeople   = { nav.navigate("people") }
                            )
                        }
                        composable(route = "stage")   { StageScreen() }
                        composable(route = "toolkit") { ToolkitScreen() }
                        composable(route = "people")  { PeopleScreen() }
                    }
                }
            }
        }
    }
}
