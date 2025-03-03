package com.oleksandr.epic.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.oleksandr.epic.details.screen.EpicDetailsScreen
import com.oleksandr.navigation.BaseNavigationDirection

fun NavGraphBuilder.epicDetailsNavigationGraph(
    navController: NavHostController,
) {
    navigation<BaseNavigationDirection.EpicDetails>(
        startDestination = EpicDetailsDirections.EpicDetails(),
    ) {
        composable<EpicDetailsDirections.EpicDetails> {
            val args = it.toRoute<EpicDetailsDirections.EpicDetails>()
            EpicDetailsScreen(args)
        }
    }
}
