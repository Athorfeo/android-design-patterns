package io.github.athorfeo.patterns.model.state

import io.github.athorfeo.patterns.util.AppException

data class UiLogicState(
    val isLoading: Boolean = false,
    val exception: AppException? = null
)
