package io.github.athorfeo.patterns.ui.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.athorfeo.patterns.model.state.UiLogicState
import io.github.athorfeo.patterns.util.AppLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.reflect.KProperty

@HiltViewModel
class DashboardViewModel @Inject constructor (
    private val loginProviderDelegate: LoginProviderDelegate
): ViewModel() {
    private val _uiLogicState = MutableStateFlow(UiLogicState())
    val uiLogicState: StateFlow<UiLogicState> = _uiLogicState

    private val loginProvider: LoginProvider by loginProviderDelegate

    fun onUpdateLoginMethod(
        method: LoginMethod
    ) {
        loginProviderDelegate.updateMethod(method)
    }

    fun login() {
        loginProvider.login()
    }
}

enum class LoginMethod {
    FACEBOOK, GOOGLE
}

interface LoginProvider {
    fun login()
}

class FacebookLogin : LoginProvider {
    override fun login() {
        AppLogger.d("Logging in with Facebook")
    }
}

class GoogleLogin : LoginProvider {
    override fun login() {
        AppLogger.d("Logging in with Google")
    }
}

class LoginProviderFactory @Inject constructor() {
    fun create(method: LoginMethod): LoginProvider = when (method) {
        LoginMethod.FACEBOOK -> FacebookLogin()
        LoginMethod.GOOGLE -> GoogleLogin()
    }
}

class LoginProviderDelegate @Inject constructor(
    private val factory: LoginProviderFactory
) {
    private var currentMethod: LoginMethod? = null
    private var currentProvider: LoginProvider? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>) : LoginProvider {
        if (currentProvider == null) {
            currentMethod?.let {
                currentProvider = factory.create(it)
            } ?: throw IllegalStateException("Login method not configured!")
        }

        return currentProvider ?: throw IllegalStateException("Provider not configured!")
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: Any?
    ) {
        throw IllegalStateException("Operator not supported!")
    }

    fun updateMethod(
        method: LoginMethod
    ) {
        currentMethod = method
        currentProvider = null
    }
}
