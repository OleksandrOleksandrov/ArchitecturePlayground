package com.oleksandr.architectureplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene

class TwoPaneScene<T : Any>(
    override val key: Any,
    override val previousEntries: List<NavEntry<T>>,
    val firstEntry: NavEntry<T>,
    val secondEntry: NavEntry<T>,
    val firstScreenWeight: Float,
    val secondScreenWeight: Float,
) : Scene<T> {

    override val entries: List<NavEntry<T>>
        get() = listOf(firstEntry, secondEntry)

    override val content: @Composable (() -> Unit)
        get() = {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.weight(firstScreenWeight)
                ) {
                    firstEntry.Content()
                }

                Box(
                    modifier = Modifier.weight(secondScreenWeight)
                ) {
                    secondEntry.Content()
                }
            }
        }

    companion object {
        const val TWO_PANE_KEY = "TwoPaneKey"
        fun twoPane() = mapOf(TWO_PANE_KEY to true)
    }
}
