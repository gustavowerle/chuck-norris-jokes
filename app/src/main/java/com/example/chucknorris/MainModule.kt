package com.example.chucknorris

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val main = module {
    viewModel {
        MainViewModel(get())
    }
}