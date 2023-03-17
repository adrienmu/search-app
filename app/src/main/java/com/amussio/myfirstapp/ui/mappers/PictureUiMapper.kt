package com.amussio.myfirstapp.ui.mappers

import com.amussio.myfirstapp.domain.models.Picture
import com.amussio.myfirstapp.ui.models.PictureUi

fun Picture.toUi(): PictureUi =
    PictureUi(url = this.previewURL, tags = this.tags, likes = this.likes)