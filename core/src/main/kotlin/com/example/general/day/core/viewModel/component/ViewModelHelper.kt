package com.example.general.day.core.viewModel.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.general.day.core.R

@Composable
fun Inject(viewModelFactory: ViewModelProvider.Factory, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalViewModelFactory provides viewModelFactory,
        content = content
    )
}

@Composable
inline fun <reified T : ViewModel> daggerViewModel(): T {
    val factory = LocalViewModelFactory.current
    return viewModel { factory.create(T::class.java) }
}

val LocalViewModelFactory = compositionLocalOf<ViewModelProvider.Factory> {
    error(R.string.error_viewModel_provider_message)
}