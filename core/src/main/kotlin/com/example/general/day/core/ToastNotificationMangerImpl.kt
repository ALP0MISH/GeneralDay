package com.example.general.day.core

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import javax.inject.Inject

class ToastNotificationMangerImpl @Inject constructor(
    private val context: Context
) : ToastNotificationManger {

    override fun showToast(@StringRes resId: Int) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_SHORT).show()
    }

    override fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }
}