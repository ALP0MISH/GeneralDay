package com.example.general.day.core.viewModel.helper

import androidx.lifecycle.ViewModel

interface ViewModelFactory<T : ViewModel> {

    fun create(): T
}