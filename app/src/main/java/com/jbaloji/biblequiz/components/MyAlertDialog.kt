package com.jbaloji.biblequiz.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.jbaloji.biblequiz.R

@Composable
fun MyAlertDialog(
    showDialog: Boolean,
    dialogText : String,
    onCancel : () -> Unit,
    onConfirm : () -> Unit,
    onDismiss : () -> Unit,
    confirmText : String = stringResource(id = R.string.confirm_txt),
    cancelText : String = stringResource(id = R.string.cancel_txt)
){

    //@TODO Make this dialog look good

    if(showDialog){

        AlertDialog(

            onDismissRequest = onDismiss,
            confirmButton = {
                Button(
                    onClick = onConfirm
                ) {
                    Text(text = confirmText)
                }
            },
            dismissButton = {
                Button(onClick = onCancel) {
                    Text(text = cancelText)
                }
            },
            text = {
                Text(text = dialogText)
            },
            properties = DialogProperties(
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOff
            )
        )

    }

}