package com.oleksandr.epic.screen

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.oleksandr.epic.model.EPICUiModel

@Composable
fun EPICContent(
    modifier: Modifier,
    list: List<EPICUiModel>
) {
    Box {
        LazyColumn(
            content = {
                items(
                    items = list,
                    key = { it.identifier.orEmpty() }
                ) {
                    EPICListItem(Modifier, it)
                }
            }
        )
    }
}

@Composable
fun EPICListItem(
    modifier: Modifier,
    item: EPICUiModel,
) {
    Column(
        modifier = modifier,
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

