package com.example.chucknorris.main

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val main = module {
    viewModel {
        MainViewModel(get())
    }
}