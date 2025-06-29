package com.oleksandr.epic.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.oleksandr.epic.details.screen.EpicDetailsContent
import com.oleksandr.epic.screen.composable.EPICList
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel
import com.oleksandr.presentation.styling.theme.AppTheme

@Composable
fun EPICContent(
    modifier: Modifier,
    windowWidthSizeClass: WindowWidthSizeClass,
    pictureOfDayUiModel: PictureOfDayUiModel?,
    list: List<EpicUiModel>,
    navigateToDetails: (EpicUiModel) -> Unit,
) {

    val selected = rememberSaveable { mutableStateOf<EpicUiModel?>(null) }
    val listState = rememberSaveable(saver = LazyListState.Saver) { LazyListState(0, 0) }
    val smallWeight = 0.7f
    val bigWeight = 1f

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Color.DarkGray,
    ) { scaffoldPaddingValues ->
        Box(
            modifier = Modifier
        ) {
            when (windowWidthSizeClass) {
                WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded ->
                    Row {
                        EPICList(
                            modifier = Modifier
                                .weight(if (windowWidthSizeClass == WindowWidthSizeClass.Medium) smallWeight else bigWeight),
                            paddingValues = scaffoldPaddingValues,
                            lazyState = listState,
                            pictureOfDayUiModel = pictureOfDayUiModel,
                            list = list,
                            onClick = {
                                selected.value = it
                            }
                        )
                        Box(
                            modifier = Modifier
                                .padding(scaffoldPaddingValues)
                                .weight(if (windowWidthSizeClass == WindowWidthSizeClass.Medium) bigWeight else smallWeight),
                        ) {
                            selected.value?.let {
                                EpicDetailsContent(
                                    modifier = Modifier,
                                    item = it,
                                )
                            }
                        }
                    }

                else ->
                    EPICList(
                        modifier = Modifier,
                        paddingValues = scaffoldPaddingValues,
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

@Composable
@Preview
private fun EPICContentMediumWindowSizePreview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            windowWidthSizeClass = WindowWidthSizeClass.Medium,
            pictureOfDayUiModel = pictureOfDayUiModel,
            list = mockList,
            navigateToDetails = {},
        )
    }
}

@Composable
@Preview
private fun EPICContentCompactWindowSizePreview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            windowWidthSizeClass = WindowWidthSizeClass.Compact,
            pictureOfDayUiModel = pictureOfDayUiModel,
            list = mockList,
            navigateToDetails = {},
        )
    }
}

private val pictureOfDayUiModel = PictureOfDayUiModel(
    date = "2023-10-01",
    explanation = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
            "\n",
    hdurl = "",
    mediaType = "image",
    title = "Picture of the Day",
    url = "",
)
private val mockList = listOf(
    EpicUiModel(
        identifier = "1",
        image = "https://example.com/image1.jpg",
        caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n",
        date = "2023-10-01"
    ),
    EpicUiModel(
        identifier = "2",
        image = "https://example.com/image2.jpg",
        caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n",
        date = "2023-10-02"
    )
)