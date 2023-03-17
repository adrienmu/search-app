package com.amussio.myfirstapp.data.models.ws

import kotlinx.serialization.Serializable

@Serializable
data class PictureWs(
    val id: Int,
    val previewURL: String,
    val tags: String,
    val likes: Int,
)
