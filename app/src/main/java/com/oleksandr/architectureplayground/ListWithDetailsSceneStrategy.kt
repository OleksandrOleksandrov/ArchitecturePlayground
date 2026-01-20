package com.oleksandr.architectureplayground

import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.scene.SceneStrategyScope
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import com.oleksandr.epic.details.screen.EpicDetailsScreen
import com.oleksandr.navigation.BaseNavigationDirection

class ListWithDetailsSceneStrategy<T : Any>(
    val windowClass: WindowSizeClass,
) : SceneStrategy<T> {

    override fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T>? {
        if (!windowClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)) {
            return null
        }

        val lastTwoEntries = entries.takeLast(2)
        val hasTwoPaneKeys = lastTwoEntries.all {
            it.metadata.containsKey(TwoPaneScene.TWO_PANE_KEY) && it.metadata[TwoPaneScene.TWO_PANE_KEY] == true
        }

        val listEntry = lastTwoEntries.first()
        return if (lastTwoEntries.size == 2 && hasTwoPaneKeys) {
            TwoPaneScene(
                key = listEntry.contentKey,
                previousEntries = entries.dropLast(1),
                listEntry = listEntry,
                detailsEntry = lastTwoEntries.last(),
            )
        } else {
            TwoPaneScene(
                key = listEntry.contentKey,
                previousEntries = entries.dropLast(1),
                listEntry = listEntry,
                detailsEntry = NavEntry(
                    key = BaseNavigationDirection.EpicEmptyDetails as T,
                ) {
                    EpicDetailsScreen(modifier = Modifier)
                },
            )
        }
    }
}
