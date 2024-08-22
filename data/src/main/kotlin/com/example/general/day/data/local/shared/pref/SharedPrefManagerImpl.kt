package com.example.general.day.data.local.shared.pref

import android.content.Context
import javax.inject.Inject

private const val IS_SAVED_THEME_KEY = "THEME_KEY"
private const val SHARED_PREF = "SHARED_PREF"

class SharedPrefManagerImpl @Inject constructor(
    private val context: Context
) : SharedPrefManager {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREF,
        Context.MODE_PRIVATE,
    )

    override var isDarkTheme: Boolean
        get() = sharedPreferences.getBoolean(IS_SAVED_THEME_KEY, false)
        set(value) = sharedPreferences.edit().putBoolean(IS_SAVED_THEME_KEY, value).apply()
}