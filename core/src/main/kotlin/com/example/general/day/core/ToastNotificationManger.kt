package com.example.general.day.core

import androidx.annotation.StringRes

interface ToastNotificationManger {
    fun showToast(@StringRes resId: Int)
    fun getString(@StringRes resId: Int): String
}