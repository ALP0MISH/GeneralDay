package com.example.general.day.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.FeatureApi
import com.example.general.day.core.communication.NavigationParams
import com.example.general.day.core.communication.NavigationRouteFlowCommunication
import com.example.general.day.data.local.shared.pref.SharedPrefManager
import com.example.general.day.presentation.di.modules.FeatureApiSet
import com.example.general.day.presentation.navigation.StartDestinationProvider
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Provider

class MainActivityViewModel @Inject constructor(
    private val navigationCommunication: NavigationRouteFlowCommunication,
    private val sharedPrefManager: SharedPrefManager,
    @FeatureApiSet
    private val featureApiSet: Set<@JvmSuppressWildcards FeatureApi>,
    private val startDestinationProvider: StartDestinationProvider
) : ViewModel() {

    val navigationRouteFlow: SharedFlow<NavigationParams> = navigationCommunication.observe()

    fun isDarkTheme(): Boolean = sharedPrefManager.isDarkTheme

    fun getFeatureApiSet() = featureApiSet

    fun startDestinationProvider() = startDestinationProvider

    fun setDarkTheme(isDarkTheme: Boolean) {
        sharedPrefManager.isDarkTheme = isDarkTheme
    }
}

@Suppress("UNCHECKED_CAST")
class ApplicationViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<MainActivityViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainActivityViewModel::class.java)
        return viewModelProvider.get() as T
    }
}