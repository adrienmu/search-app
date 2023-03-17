package com.amussio.myfirstapp.domain.mappers

import com.amussio.myfirstapp.data.models.ws.PictureWs
import com.amussio.myfirstapp.domain.models.Picture

fun PictureWs.toDomain(): Picture =
    Picture(id = this.id, previewURL = this.previewURL, tags = this.tags)