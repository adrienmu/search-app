package com.amussio.myfirstapp.domain.usecases

import com.amussio.myfirstapp.data.repository.PicturesRepository
import com.amussio.myfirstapp.domain.mappers.toDomain
import com.amussio.myfirstapp.domain.models.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QueryPicturesUseCase(private val picturesRepository: PicturesRepository) {

    fun invoke(query: String?): Flow<List<Picture>> =
        picturesRepository.queryPictures(query).map {  it.hits.map { it.toDomain() } }
}