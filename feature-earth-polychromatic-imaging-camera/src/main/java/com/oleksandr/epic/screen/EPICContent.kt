package com.oleksandr.epic.screen

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.oleksandr.epic.details.screen.EpicDetailsContent
import com.oleksandr.epic.screen.composable.EPICList
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun EPICContent(
    modifier: Modifier,
    pictureOfDayUiModel: PictureOfDayUiModel?,
    list: List<EpicUiModel>,
    navigateToDetails: (EpicUiModel) -> Unit,
) {
    val context = LocalContext.current

    val activity = context as Activity

    val windowSize = calculateWindowSizeClass(activity = activity)

    val windowWidthClass = windowSize.widthSizeClass

    val selected = rememberSaveable { mutableStateOf<EpicUiModel?>(null) }
    val listState = rememberSaveable(saver = LazyListState.Saver) { LazyListState(0, 0) }

    Box(
        modifier = modifier,
    ) {
        when (windowWidthClass) {
            WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
                Row {
                    EPICList(
                        modifier = Modifier.weight(if (windowWidthClass == WindowWidthSizeClass.Medium) 0.7f else 1f),
                        lazyState = listState,
                        pictureOfDayUiModel = pictureOfDayUiModel,
                        list = list,
                        onClick = {
                            selected.value = it
                        }
                    )
                    Box(
                        modifier = Modifier.weight(if (windowWidthClass == WindowWidthSizeClass.Medium) 1f else 0.7f),
                    ) {
                        selected.value?.let {
                            EpicDetailsContent(
                                modifier = Modifier,
                                item = it,
                            )
                        }
                    }
                }
            }

            else -> {
                EPICList(
                    modifier = Modifier,
                    lazyState = listState,
                    pictureOfDayUiModel = pictureOfDayUiModel,
                    list = list,
                    onClick = {
                        selected.value = it
                        navigateToDetails(it)
                    }
                )
            }
        }
    }
}

