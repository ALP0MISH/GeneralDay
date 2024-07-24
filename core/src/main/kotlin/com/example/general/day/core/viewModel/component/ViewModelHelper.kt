package com.example.general.day.core.viewModel.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Inject(viewModelFactory: ViewModelProvider.Factory, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalViewModelFactory provides viewModelFactory,
        content = content
    )
}

@Composable
inline fun <reified T : ViewModel> daggerViewModel(): T =
    with(LocalViewModelFactory.current) { viewModel { create(T::class.java) } }


//TODO: ADD docs
val LocalViewModelFactory = compositionLocalOf<ViewModelProvider.Factory>() {
    error("Никакая ViewModelFactory не была предоставлена через локальную ViewModelFactory")
}