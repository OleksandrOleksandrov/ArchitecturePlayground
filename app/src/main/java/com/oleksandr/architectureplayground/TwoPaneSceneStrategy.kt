package com.oleksandr.architectureplayground

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.scene.SceneStrategyScope
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND

class TwoPaneSceneStrategy<T : Any>(
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

        return if (lastTwoEntries.size == 2 && hasTwoPaneKeys) {
            val firstEntry = lastTwoEntries.first()
            val secondEntry = lastTwoEntries.last()

            TwoPaneScene(
                key = firstEntry.contentKey,
                previousEntries = entries.dropLast(1),
                firstEntry = firstEntry,
                secondEntry = secondEntry,
                firstScreenWeight = 0.3f,
                secondScreenWeight = 0.7f,
            )
        } else {
            null
        }
    }
}
