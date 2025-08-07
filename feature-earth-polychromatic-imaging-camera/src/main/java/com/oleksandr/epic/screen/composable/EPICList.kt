package com.oleksandr.epic.screen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleksandr.common.core.preview.AppPreview
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel
import com.oleksandr.presentation.styling.theme.AppTheme

@Composable
internal fun EPICList(
    modifier: Modifier,
    paddingValues: PaddingValues,
    lazyState: LazyListState,
    pictureOfDayUiModel: PictureOfDayUiModel?,
    list: List<EpicUiModel>,
    onClick: (EpicUiModel) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = paddingValues,
        state = lazyState,
        content = {
            item {
                pictureOfDayUiModel?.let {
                    PictureOfDay(
                        modifier = Modifier,
                        pictureOfDayUiModel = it,
                    )
                }
            }
            items(
                items = list,
                key = { it.identifier.orEmpty() }
            ) {
                EPICListItem(
                    modifier = Modifier
                        .clickable { onClick(it) },
                    item = it,
                )
            }
        }
    )
}

@Composable
@AppPreview
private fun EPICListPreview() {
    AppTheme {
        EPICList(
            modifier = Modifier,
            pictureOfDayUiModel = null,
            list = listOf(
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
            ),
            paddingValues = PaddingValues(0.dp),
            lazyState = LazyListState(0, 0),
            onClick = {},
        )
    }
}