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
import com.oleksandr.presentation.core.model.EpicUiModel

@Composable
fun EPICContent(
    modifier: Modifier,
    list: List<EpicUiModel>,
    navigateToDetails: (EpicUiModel) -> Unit,
) {
    Box {
        LazyColumn(
            content = {
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
                modifier = Modifier.padding(8.dp),
            ) {
                Text(
                    item.caption.orEmpty() + item.date,
                )
//        AsyncImage(
//            model = Uri.parse(item.image),
//            contentScale = ContentScale.FillHeight,
//            contentDescription = null,
//            alignment = Alignment.CenterStart,
////        placeholder = painterResource(id = R.drawable.ic_product_placeholder),
//            modifier = Modifier
//                .padding(start = 24.dp)
//                .fillMaxWidth()
//                .height(32.dp)
//        )
            }
        }
    }
}

