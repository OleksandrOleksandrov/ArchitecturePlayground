package com.oleksandr.epic.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.oleksandr.presentation.core.model.PictureOfDayUiModel

@Composable
fun PictureOfDay(
    modifier: Modifier = Modifier,
    pictureOfDayUiModel: PictureOfDayUiModel,
) {
    val placeholder = android.R.drawable.ic_menu_gallery // TODO replace placeholder
    Box(
        modifier = modifier.padding(8.dp),
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Column(
                modifier = Modifier,
            ) {
                with(pictureOfDayUiModel) {
                    AsyncImage(
                        model = thumbs?.toUri() ?: url.toUri(), // TODO test it out, for video it is thumbs for image it is url.
                        contentScale = ContentScale.FillWidth,
                        contentDescription = null,
                        alignment = Alignment.CenterStart,
                        placeholder = painterResource(id = placeholder),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
