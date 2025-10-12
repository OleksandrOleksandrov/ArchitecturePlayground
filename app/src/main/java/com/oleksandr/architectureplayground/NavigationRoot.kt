package com.oleksandr.architectureplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.oleksandr.epic.details.screen.EpicDetailsScreen
import com.oleksandr.epic.screen.EPICScreen
import com.oleksandr.navigation.BaseNavigationDirection

@Composable
fun NavigationRoot(
    modifier: Modifier,
) {

    val backStack = rememberNavBackStack(BaseNavigationDirection.EPIC)
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        sceneStrategy = TwoPaneSceneStrategy(windowClass),
        entryProvider = { key ->
            when (key) {
                is BaseNavigationDirection.Main -> NavEntry(key) {
                    Box(modifier) {
                        Text("main")
                    }
                }

                is BaseNavigationDirection.EPIC -> NavEntry(
                    key = key,
                    metadata = TwoPaneScene.twoPane()
                ) {
                    EPICScreen { model ->
                        backStack.addDetail(
                            BaseNavigationDirection.EpicDetails(
                                identifier = model.identifier,
                                caption = model.caption,
                                image = model.image,
                                date = model.date,
                            )
                        )
                    }
                }

                is BaseNavigationDirection.EpicDetails -> NavEntry(
                    key = key,
                    metadata = TwoPaneScene.twoPane()
                ) {
                    EpicDetailsScreen(
                        modifier = modifier,
                        identifier = key.identifier.orEmpty(),
                    )
                }

                else -> throw RuntimeException("Unknown destination")
            }
        }
    )
}

private fun NavBackStack<NavKey>.addDetail(detailRoute: BaseNavigationDirection.EpicDetails) {
    // Remove any existing detail routes, then add the new detail route
    removeIf { it is BaseNavigationDirection.EpicDetails }
    add(detailRoute)
}