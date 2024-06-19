package com.example.general.day.core.managers

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ShowToastManagerImpl @Inject constructor(
    private val context: Context
) : ShowToastManager {
    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }
}