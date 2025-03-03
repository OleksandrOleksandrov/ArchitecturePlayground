package com.oleksandr.epic.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandr.presentation.core.model.EpicUiModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EPICScreen(navigateToDetails: (EpicUiModel) -> Unit) {

    val viewModel: EPICViewModel = koinViewModel()
    val epicList = viewModel.epicList.collectAsStateWithLifecycle(emptyList())
    EPICContent(
        modifier = Modifier,
        list = epicList.value ?: emptyList(),
        navigateToDetails = navigateToDetails
    )
}