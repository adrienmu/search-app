package com.amussio.myfirstapp.data.models.ws

import kotlinx.serialization.Serializable

@Serializable
data class QueryResponseWs(
    val total: Int,
    val hits: List<PictureWs>,
)
