package com.oleksandr.architectureplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oleksandr.epic.screen.EPICScreen
import com.oleksandr.navigation.BaseNavigationDirection

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    startDestination: Any,
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable<BaseNavigationDirection.Main> {
            Box {
                Text("main")
            }
        }

        composable<BaseNavigationDirection.EPIC> {
            EPICScreen()
        }
    }
}