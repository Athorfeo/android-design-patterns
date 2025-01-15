package io.github.athorfeo.patterns.navigation

import androidx.annotation.StringRes

sealed class Screen(val route: String, @StringRes val title: Int? = null) {
    abstract fun buildRoute(): String

    data object Dashboard: Screen("dashboard_screen") {
        override fun buildRoute(): String {
            return route
        }
    }
}

val rootScreens = listOf<Screen>(
    Screen.Dashboard
)
