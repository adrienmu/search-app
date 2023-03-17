package com.amussio.myfirstapp.data.ws

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
object RetrofitBuilder {
    private const val BASE_URL: String = "https://pixabay.com/"

    private const val APIKEY_NAME = "key"
    private const val APIKEY_VALUE = "18021445-326cf5bcd3658777a9d22df6f"

    private const val IMAGE_TYPE_NAME = "image_type"
    private const val IMAGE_TYPE_VALUE = "photo"



    private val apikeyInterceptor = Interceptor { chain ->
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(APIKEY_NAME, APIKEY_VALUE)
            .build()
        request = request.newBuilder().url(url).build()
        chain.proceed(request)
    }

    private val imageTypeInterceptor = Interceptor { chain ->
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(IMAGE_TYPE_NAME, IMAGE_TYPE_VALUE)
            .build()
        request = request.newBuilder().url(url).build()
        chain.proceed(request)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(apikeyInterceptor)
        .addInterceptor(imageTypeInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    private val contentType =  "application/json".toMediaType()
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val pixabayApi: PixabayApi = retrofit.create(PixabayApi::class.java)
}