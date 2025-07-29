package com.oleksandr.epic.details.screen.composable

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
fun EpicDetailsView(
    modifier: Modifier,
    model: EpicUiModel? = null,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            model?.caption.orEmpty() + model?.date,
        )
        AsyncImage(
            model = model?.image?.toUri(),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            alignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}