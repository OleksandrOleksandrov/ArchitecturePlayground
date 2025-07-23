package com.oleksandr.epic.details.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.oleksandr.presentation.core.model.EpicUiModel

@Composable
fun EpicDetailsContent(
    modifier: Modifier,
    item: EpicUiModel,
) {
    Box {
        Column(
            modifier = modifier,
        ) {
            Text(
                item.caption.orEmpty() + item.date,
            )
            AsyncImage(
                model = item.image?.toUri(),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                alignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}