package io.github.athorfeo.patterns.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import io.github.athorfeo.patterns.model.state.UiLogicState
import io.github.athorfeo.patterns.ui.component.ErrorAlertDialog
import io.github.athorfeo.patterns.ui.component.Loading
import io.github.athorfeo.patterns.ui.theme.ApplicationTheme

@Composable
fun QuerySearchRoute(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val uiLogicState by viewModel.uiLogicState.collectAsStateWithLifecycle()

    QuerySearchScreen(
        uiLogicState,
        { }
    )
}

@Composable
fun QuerySearchScreen(
    uiLogicState: UiLogicState,
    onDismissErrorDialog: () -> Unit
) {
    if (uiLogicState.isLoading) {
        Loading()
    } else {
        if(uiLogicState.exception != null) {
            ErrorAlertDialog(
                onDismissErrorDialog,
                onDismissErrorDialog,
                uiLogicState.exception.title,
                uiLogicState.exception.description
            )
        }

        Column {
            Text("Hello World")
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    ApplicationTheme {
        val uiLogicState = UiLogicState()
        QuerySearchScreen(uiLogicState, {})
    }
}
