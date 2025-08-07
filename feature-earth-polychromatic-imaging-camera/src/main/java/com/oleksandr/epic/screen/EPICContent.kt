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
import com.oleksandr.common.core.preview.AppPreview
import com.oleksandr.epic.details.screen.composable.EpicDetailsView
import com.oleksandr.epic.screen.composable.EPICList
import com.oleksandr.epic.screen.contract.ViewIntent
import com.oleksandr.epic.screen.contract.ViewState
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel
import com.oleksandr.presentation.styling.theme.AppTheme
import com.oleksandr.presentation.styling.theme.core.Theme

@Composable
internal fun EPICContent(
    modifier: Modifier,
    windowWidthSizeClass: WindowWidthSizeClass,
    state: ViewState,
    onIntent: (ViewIntent) -> Unit = {},
) {

    val selected = rememberSaveable { mutableStateOf<EpicUiModel?>(null) }
    val listState = rememberSaveable(saver = LazyListState.Saver) { LazyListState(0, 0) }
    val smallWeight = 0.7f
    val bigWeight = 1f

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Theme.color.themeNColor.n50,
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
                            pictureOfDayUiModel = state.pictureUiState,
                            list = state.epicList,
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
                                EpicDetailsView(
                                    modifier = Modifier,
                                    model = it,
                                )
                            }
                        }
                    }

                else ->
                    EPICList(
                        modifier = Modifier,
                        paddingValues = scaffoldPaddingValues,
                        lazyState = listState,
                        pictureOfDayUiModel = state.pictureUiState,
                        list = state.epicList,
                        onClick = {
                            selected.value = it
                            onIntent(ViewIntent.OnEpicItemTappedIntent(it))
                        }
                    )
            }

        }
    }
}

@Composable
@AppPreview
private fun EPICContentMediumWindowSizePreview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            windowWidthSizeClass = WindowWidthSizeClass.Medium,
            state = ViewState(
                epicList = mockList,
                pictureUiState = pictureOfDayUiModel,
            ),
        )
    }
}

@Composable
@AppPreview
private fun EPICContentCompactWindowSizePreview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            windowWidthSizeClass = WindowWidthSizeClass.Compact,
            state = ViewState(
                epicList = mockList,
                pictureUiState = pictureOfDayUiModel,
            ),
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