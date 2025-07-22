package com.oleksandr.epic.screen

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandr.epic.screen.contract.ViewEvent
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.platform.base.composable.rememberFlowWithLifecycle
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun EPICScreen(onAction: (EpicUiModel) -> Unit) {

    val scope = rememberCoroutineScope()
    val viewModel: EPICViewModel = koinViewModel()
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    val eventFlow = rememberFlowWithLifecycle(viewModel.singleEvent)

    val activity = LocalActivity.current as Activity

    val windowSize = calculateWindowSizeClass(activity = activity)

    val windowWidthClass = windowSize.widthSizeClass

    LaunchedEffect(Unit) {
        eventFlow.collect { event ->
            when (event) {
                is ViewEvent.ShowError -> {
                    // Handle error, e.g., show a snackbar or dialog
                }
                is ViewEvent.NavigateToEpicDetails -> onAction(event.model)
            }
        }
    }

    EPICContent(
        modifier = Modifier,
        windowWidthSizeClass = windowWidthClass,
        state = state.value,
        onIntent = { intent ->
            scope.launch {
                viewModel.processIntent(intent)
            }
        },
    )
}