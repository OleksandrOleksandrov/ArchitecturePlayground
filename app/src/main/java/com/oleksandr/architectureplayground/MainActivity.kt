package com.oleksandr.architectureplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.oleksandr.navigation.BaseNavigationDirection
import com.oleksandr.presentation.styling.theme.AppTheme

class MainActivity : ComponentActivity() {
    private var navHostController: NavHostController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT // Force portrait mode
        setContent {
            navHostController = rememberNavController()
            navHostController?.let {
                AppTheme {
                    NavigationGraph(
                        navHostController = it,
                        startDestination = BaseNavigationDirection.EPIC,
                    )
                }
            }
        }
    }
}