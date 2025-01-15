package io.github.athorfeo.patterns.ui.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.athorfeo.patterns.model.state.UiLogicState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(): ViewModel() {
    private val _uiLogicState = MutableStateFlow(UiLogicState())
    val uiLogicState: StateFlow<UiLogicState> = _uiLogicState
}
