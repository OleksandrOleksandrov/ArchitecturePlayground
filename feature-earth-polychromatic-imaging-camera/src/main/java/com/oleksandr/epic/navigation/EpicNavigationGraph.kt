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
            EPICScreen { model ->
                navController.navigate(BaseNavigationDirection.EpicDetails(
                    identifier = model.identifier,
                    caption = model.caption,
                    image = model.image,
                    date = model.date,
                ))
            }
        }
    }
}
