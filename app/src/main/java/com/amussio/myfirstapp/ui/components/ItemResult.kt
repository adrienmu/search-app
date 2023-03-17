package com.amussio.myfirstapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amussio.myfirstapp.ui.models.PictureUi
import com.amussio.myfirstapp.ui.theme.MyFirstAppTheme

@Composable
fun ItemResult(pictureUi: PictureUi) {
    Text(text = pictureUi.url)
}

val pictureUiMocked = PictureUi(
    url = "https://url.com",
    tags = "car, lego, great",
    likes = 27,
)

@Preview
@Composable
fun PreviewItemResult() {
    MyFirstAppTheme {
        ItemResult(pictureUi = pictureUiMocked)
    }
}