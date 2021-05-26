package com.wal.winteranimelist2021.di

import com.wal.winteranimelist2021.core.domain.usecase.AnimeInteractor
import com.wal.winteranimelist2021.core.domain.usecase.AnimeUseCase
import com.wal.winteranimelist2021.ui.detail.DetailViewModel
import com.wal.winteranimelist2021.ui.favorite.FavoriteViewModel
import com.wal.winteranimelist2021.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory <AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}