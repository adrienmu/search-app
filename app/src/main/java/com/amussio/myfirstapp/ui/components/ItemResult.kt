package com.amussio.myfirstapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amussio.myfirstapp.ui.models.PictureUi
import com.amussio.myfirstapp.ui.theme.MyFirstAppTheme

@Composable
fun ItemResult(pictureUi: PictureUi) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = pictureUi.url)
    }

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
        Surface {
            ItemResult(pictureUi = pictureUiMocked)
        }
    }
}