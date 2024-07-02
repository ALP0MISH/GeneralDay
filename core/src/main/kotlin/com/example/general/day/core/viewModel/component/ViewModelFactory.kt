package com.example.general.day.core.viewModel.component

import androidx.lifecycle.ViewModel

interface ViewModelFactory<T : ViewModel> {

    fun create(): T
}