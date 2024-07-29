package com.example.general.day.core.managers

import android.app.Application
import android.widget.Toast
import javax.inject.Inject

class ShowToastManagerImpl @Inject constructor(
    private val context: Application
) : ShowToastManager {
    override fun showToast(message: String) {
        Toast.makeText(context.applicationContext, message, Toast.LENGTH_SHORT)
            .show()
    }
}