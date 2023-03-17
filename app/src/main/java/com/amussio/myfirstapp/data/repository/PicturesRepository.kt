package com.amussio.myfirstapp.data.repository

import com.amussio.myfirstapp.data.models.ws.QueryResponseWs
import kotlinx.coroutines.flow.Flow

interface PicturesRepository {
    fun queryPictures(query: String?): Flow<QueryResponseWs>
}