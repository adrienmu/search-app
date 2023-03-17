package com.amussio.myfirstapp.data.network

import com.amussio.myfirstapp.data.network.interceptors.ApiKeyInterceptor
import com.amussio.myfirstapp.data.network.interceptors.ImageTypeInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

private const val BASE_URL: String = "https://pixabay.com/"


fun provideClient(apikeyInterceptor: ApiKeyInterceptor, imageTypeInterceptor: ImageTypeInterceptor) = OkHttpClient.Builder()
    .addInterceptor(apikeyInterceptor)
    .addInterceptor(imageTypeInterceptor)
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

fun provideRetrofit(client: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()
}

fun providePixabayApi(retrofit: Retrofit): PixabayApi = retrofit.create(PixabayApi::class.java)