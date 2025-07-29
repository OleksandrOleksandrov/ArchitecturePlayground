package com.oleksandr.epic.details.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandr.presentation.styling.theme.core.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpicDetailsScreen() {

    val viewModel: EpicDetailsViewModel = koinViewModel()
    val state = viewModel.viewState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Theme.color.themeNColor.n50,
    ) { scaffoldPaddingValues ->
        EpicDetailsContent(
            modifier = Modifier.padding(scaffoldPaddingValues),
            state = state.value,
        )
    }
}