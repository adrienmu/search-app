package com.amussio.myfirstapp.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(APIKEY_NAME, APIKEY_VALUE)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

    companion object {
        private const val APIKEY_NAME = "key"
        private const val APIKEY_VALUE = "18021445-326cf5bcd3658777a9d22df6f"
    }
}