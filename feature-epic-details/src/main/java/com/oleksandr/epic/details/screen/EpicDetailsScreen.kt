package com.oleksandr.epic.details.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oleksandr.epic.details.navigation.EpicDetailsDirections
import com.oleksandr.presentation.core.model.EpicUiModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpicDetailsScreen(model: EpicDetailsDirections.EpicDetails) {

    val viewModel: EpicDetailsViewModel = koinViewModel()
    EpicDetailsContent(
        modifier = Modifier,
        EpicUiModel(
            identifier = model.identifier,
            caption = model.caption,
            image = model.image,
            date = model.date,
        ),
    )
}