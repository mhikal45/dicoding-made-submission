package com.wal.winteranimelist2021.maps

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapsModule = module {
    viewModel { FavoriteViewModel(get()) }
}