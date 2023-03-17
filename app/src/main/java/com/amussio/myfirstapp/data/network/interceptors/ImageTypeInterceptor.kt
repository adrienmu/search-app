package com.amussio.myfirstapp.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ImageTypeInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(IMAGE_TYPE_NAME, IMAGE_TYPE_VALUE)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

    companion object {
        private const val IMAGE_TYPE_NAME = "image_type"
        private const val IMAGE_TYPE_VALUE = "photo"
    }
}