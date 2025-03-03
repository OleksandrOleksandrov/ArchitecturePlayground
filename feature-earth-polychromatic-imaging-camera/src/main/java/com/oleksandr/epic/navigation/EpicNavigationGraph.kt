package com.oleksandr.epic.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.oleksandr.epic.screen.EPICScreen
import com.oleksandr.navigation.BaseNavigationDirection

fun NavGraphBuilder.epicNavigationGraph(
    navController: NavHostController,
) {
    navigation<BaseNavigationDirection.EPIC>(
        startDestination = EpicDirections.Epic,
    ) {
        composable<EpicDirections.Epic> {
            EPICScreen { moddel ->
                navController.navigate(BaseNavigationDirection.EpicDetails(
                    moddel.identifier,
                    moddel.caption,
                    moddel.image,
                    moddel.date,
                ))
            }
        }
    }
}
