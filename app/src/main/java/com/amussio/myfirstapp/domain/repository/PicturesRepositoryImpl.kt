package com.amussio.myfirstapp.domain.repository

import com.amussio.myfirstapp.data.repository.PicturesRepository
import com.amussio.myfirstapp.data.ws.PixabayApi
import kotlinx.coroutines.flow.flow

class PicturesRepositoryImpl(val api: PixabayApi): PicturesRepository  {

    override fun queryPictures(query: String?) = flow {
        emit(api.queryPictures(query = query))
    }

}