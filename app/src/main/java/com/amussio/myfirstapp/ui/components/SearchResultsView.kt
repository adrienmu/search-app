package com.amussio.myfirstapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amussio.myfirstapp.ui.models.PictureUi

@Composable
fun SearchResultsView(pictures: List<PictureUi>) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {

        pictures.forEach {
            ItemResult(pictureUi = it)
        }
    }
}