package com.amussio.myfirstapp.domain.mappers

import com.amussio.myfirstapp.data.models.ws.PictureWs
import com.amussio.myfirstapp.domain.models.Picture
import com.amussio.myfirstapp.ui.mappers.toUi
import com.amussio.myfirstapp.ui.models.PictureUi
import org.junit.jupiter.api.Test


class PictureMapperKtTest {

    @Test
    fun pictureWsToDomain() {
        val pictureWs = PictureWs(id = 1, previewURL = "previewUrl", tags = "tags", likes = 18)
        val pictureDomain = Picture(id = 1, previewURL = "previewUrl", tags = "tags", likes = 18)
        assert(pictureWs.toDomain() == pictureDomain)
    }

    @Test
    fun pictureDomainToUi() {
        val pictureDomain = Picture(id = 1, previewURL = "previewUrl", tags = "tags", likes = 18)
        val pictureUi = PictureUi(url = "previewUrl", tags = "tags", likes = 18)
        assert(pictureDomain.toUi() == pictureUi)
    }
}