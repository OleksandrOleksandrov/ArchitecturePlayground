package com.oleksandr.epic.details.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oleksandr.epic.details.navigation.EpicDetailsDirections
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpicDetailsScreen(model: EpicDetailsDirections.EpicDetails) {

    val viewModel: EpicDetailsViewModel = koinViewModel()
    EpicDetailsContent(
        modifier = Modifier,
        model,
    )
}