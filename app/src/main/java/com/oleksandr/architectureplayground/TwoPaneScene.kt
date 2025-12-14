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
    val listEntry: NavEntry<T>,
    val detailsEntry: NavEntry<T>,
    val listScreenWeight: Float,
    val detailsScreenWeight: Float,
) : Scene<T> {

    override val entries: List<NavEntry<T>>
        get() = listOf(listEntry, detailsEntry)

    override val content: @Composable (() -> Unit)
        get() = {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.weight(listScreenWeight)
                ) {
                    listEntry.Content()
                }

                Box(
                    modifier = Modifier.weight(detailsScreenWeight)
                ) {
                    detailsEntry.Content()
                }
            }
        }

    companion object {
        const val TWO_PANE_KEY = "TwoPaneKey"
        fun twoPane() = mapOf(TWO_PANE_KEY to true)
    }
}
