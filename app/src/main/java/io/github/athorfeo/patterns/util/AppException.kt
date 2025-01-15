package io.github.athorfeo.patterns.util

import androidx.annotation.StringRes
import io.github.athorfeo.patterns.R
import java.lang.Exception

open class AppException(
    @StringRes val title: Int = R.string.title_default_error_dialog,
    @StringRes val description: Int = R.string.message_default_error_dialog,
    cause: Throwable? = null
): Exception(cause)
