package com.oleksandr.epic.screen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel

@Composable
internal fun EPICList(
    modifier: Modifier,
    lazyState: LazyListState,
    pictureOfDayUiModel: PictureOfDayUiModel?,
    list: List<EpicUiModel>,
    onClick: (EpicUiModel) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
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