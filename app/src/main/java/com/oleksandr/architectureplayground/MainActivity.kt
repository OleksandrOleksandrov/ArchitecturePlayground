package com.oleksandr.architectureplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.oleksandr.architectureplayground.ui.theme.ArchitecturePlaygroundTheme
import com.oleksandr.navigation.BaseNavigationDirection
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: ViewModel by viewModel()

    private var navHostController: NavHostController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT // Force portrait mode
        setContent {
            navHostController = rememberNavController()
            navHostController?.let {
                ArchitecturePlaygroundTheme {
                    NavigationGraph(
                        navHostController = it,
                        startDestination = BaseNavigationDirection.EPIC,
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArchitecturePlaygroundTheme {
        Greeting("Android")
    }
}