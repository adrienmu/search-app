package com.amussio.myfirstapp.data.models.ws

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
data class PictureWs(
    val id: Int,
    val previewURL: String,
    val tags: String,
)
