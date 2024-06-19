package com.example.general.day.core

import android.content.Context
import androidx.annotation.StringRes

sealed class ResourceString {
    /** Return formatted string message. */
    abstract fun format(context: Context): String
}

/** Wrapper for string message. */
data class TextResourceString(val text: String) : ResourceString() {
    override fun format(context: Context): String = text
}

/** Wrapper for message from string resource. */
data class IdResourceString(@StringRes val id: Int) : ResourceString() {
    override fun format(context: Context): String = context.getString(id)
}