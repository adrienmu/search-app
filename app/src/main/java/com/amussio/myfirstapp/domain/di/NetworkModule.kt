package com.amussio.myfirstapp.domain.di

import com.amussio.myfirstapp.data.network.interceptors.ApiKeyInterceptor
import com.amussio.myfirstapp.data.network.interceptors.ImageTypeInterceptor
import com.amussio.myfirstapp.data.network.provideClient
import com.amussio.myfirstapp.data.network.providePixabayApi
import com.amussio.myfirstapp.data.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { ApiKeyInterceptor() }
    factory { ImageTypeInterceptor() }
    factory { provideClient(get(), get()) }
    factory { providePixabayApi(get()) }
    single { provideRetrofit(get()) }
}