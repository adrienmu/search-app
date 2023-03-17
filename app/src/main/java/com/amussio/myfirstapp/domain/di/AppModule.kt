package com.amussio.myfirstapp.domain.di

import com.amussio.myfirstapp.data.repository.PicturesRepository
import com.amussio.myfirstapp.domain.repository.PicturesRepositoryImpl
import com.amussio.myfirstapp.domain.usecases.QueryPicturesUseCase
import com.amussio.myfirstapp.ui.screens.SearchScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<PicturesRepository> { PicturesRepositoryImpl(get()) }
    single { QueryPicturesUseCase(get()) }
    viewModel { SearchScreenViewModel(get()) }
}