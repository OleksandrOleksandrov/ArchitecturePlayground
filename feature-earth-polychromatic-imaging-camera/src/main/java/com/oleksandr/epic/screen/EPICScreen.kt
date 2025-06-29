package com.oleksandr.epic.screen

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandr.presentation.core.model.EpicUiModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun EPICScreen(navigateToDetails: (EpicUiModel) -> Unit) {

    val viewModel: EPICViewModel = koinViewModel()
    val epicList = viewModel.epicList.collectAsStateWithLifecycle(emptyList())
    val apod = viewModel.apod.collectAsStateWithLifecycle(null)

    val activity = LocalActivity.current as Activity

    val windowSize = calculateWindowSizeClass(activity = activity)

    val windowWidthClass = windowSize.widthSizeClass

    EPICContent(
        modifier = Modifier,
        windowWidthSizeClass = windowWidthClass,
        pictureOfDayUiModel = apod.value,
        list = epicList.value ?: emptyList(),
        navigateToDetails = navigateToDetails
    )
}