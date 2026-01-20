package com.oleksandr.epic.details.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandr.epic.details.screen.contract.ViewIntent
import com.oleksandr.presentation.styling.theme.core.Theme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpicDetailsScreen(
    modifier: Modifier = Modifier,
    identifier: String? = null,
) {

    val viewModel: EpicDetailsViewModel = koinViewModel()
    val state = viewModel.viewState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()

    LaunchedEffect(identifier) {
        scope.launch {
            identifier?.let { viewModel.processIntent(ViewIntent.OnStartIntent(it)) }
        }
    }

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Theme.color.themeNColor.n50,
    ) { scaffoldPaddingValues ->
        EpicDetailsContent(
            modifier = Modifier.padding(scaffoldPaddingValues),
            state = state.value,
        )
    }
}