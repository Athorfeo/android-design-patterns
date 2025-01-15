package io.github.athorfeo.patterns.ui.component

import androidx.annotation.StringRes
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.athorfeo.patterns.R
import io.github.athorfeo.patterns.ui.theme.ApplicationTheme

private const val TITLE_DIALOG_UI_TAG = "TITLE_DIALOG_UI_TAG"
private const val TEXT_DIALOG_UI_TAG = "TEXT_DIALOG_UI_TAG"
private const val BUTTON_DIALOG_UI_TAG = "BUTTON_DIALOG_UI_TAG"

@Composable
fun ErrorAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    @StringRes dialogTitle: Int,
    @StringRes dialogText: Int
) {
    AlertDialog(
        title = {
            Text(
                modifier = Modifier.testTag(TITLE_DIALOG_UI_TAG),
                text = stringResource(dialogTitle)
            )
        },
        text = {
            Text(
                modifier = Modifier.testTag(TEXT_DIALOG_UI_TAG),
                text = stringResource(dialogText)
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                modifier = Modifier.testTag(BUTTON_DIALOG_UI_TAG),
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(stringResource(R.string.dismiss_action))
            }
        }
    )
}

@Preview
@Composable
fun ErrorAlertDialogPreview() {
    ApplicationTheme {
        ErrorAlertDialog(
            {},
            {},
            R.string.title_default_error_dialog,
            R.string.message_default_error_dialog
        )
    }
}
