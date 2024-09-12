package com.example.general.day.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.communication.NavigationParams
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Provider

class ApplicationViewModel @Inject constructor(
    private val navigationCommunication: NavigationRouteFlowCommunication,
    private val sharedPrefManager: SharedPrefManager
) : ViewModel() {

    val navigationRouteFlow: SharedFlow<NavigationParams> = navigationCommunication.observe()

    fun isDarkTheme(): Boolean = sharedPrefManager.isDarkTheme

    fun setDarkTheme(isDarkTheme: Boolean) {
        sharedPrefManager.isDarkTheme = isDarkTheme
    }
}

@Suppress("UNCHECKED_CAST")
class ApplicationViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<ApplicationViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == ApplicationViewModel::class.java)
        return viewModelProvider.get() as T
    }
}