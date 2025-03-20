package com.oleksandr.epic.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oleksandr.presentation.core.model.EpicUiModel

@Composable
fun EPICListItem(
    modifier: Modifier,
    item: EpicUiModel,
) {
    Box(
        modifier = modifier.padding(8.dp),
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier,
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
            ) {
                Text(
                    text = item.caption.orEmpty(),
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.date.orEmpty(),
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}
