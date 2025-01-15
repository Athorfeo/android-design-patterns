package io.github.athorfeo.patterns.util

import java.lang.Exception

interface Logger {
    fun d(text: String)
    fun e(text: String)
    fun e(exception: Exception)

    companion object {
        const val APPLICATION_TAG = "[Athorfeo]"
        const val DEBUG_TAG = "[Debug]"
        const val ERROR_TAG = "[Error]"
    }
}
