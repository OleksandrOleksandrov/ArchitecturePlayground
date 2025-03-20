package com.oleksandr.epic.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleksandr.epic.screen.composable.EPICListItem
import com.oleksandr.epic.screen.composable.PictureOfDay
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel

@Composable
fun EPICContent(
    modifier: Modifier,
    pictureOfDayUiModel: PictureOfDayUiModel?,
    list: List<EpicUiModel>,
    navigateToDetails: (EpicUiModel) -> Unit,
) {
    Box(
        modifier = modifier,
    ) {
        LazyColumn(
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
                            .clickable { navigateToDetails(it) },
                        item = it,
                    )
                }
            }
        )
    }
}

