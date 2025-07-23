package com.oleksandr.epic.details.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oleksandr.epic.details.navigation.EpicDetailsDirections
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.styling.theme.core.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpicDetailsScreen(model: EpicDetailsDirections.EpicDetails) {

    val viewModel: EpicDetailsViewModel = koinViewModel()

    Scaffold(
        modifier = Modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Theme.color.themeNColor.n50,
    ) { scaffoldPaddingValues ->
        EpicDetailsContent(
            modifier = Modifier.padding(scaffoldPaddingValues),
            EpicUiModel(
                identifier = model.identifier,
                caption = model.caption,
                image = model.image,
                date = model.date,
            ),
        )
    }
}