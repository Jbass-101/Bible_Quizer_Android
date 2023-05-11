package com.jbaloji.biblequiz.presentation.auth.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.jbaloji.biblequiz.R

@Composable
fun GenericTextField (
    label: String = "Label",
    placeholder: String,
    icon: Int = R.drawable.user,
    value: String,
    enable: Boolean = true,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Next,
    valueChange: (String) -> Unit
){
    val focusManager = LocalFocusManager.current

    val icons = listOf(
        R.drawable.user,    //0
        R.drawable.email,   //1
        R.drawable.password //2
    )

    OutlinedTextField(
        enabled = enable,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ) ,
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
            ),
        value = value,
        onValueChange = { string ->
            valueChange(string)
        },
        placeholder = {
            Text(text = placeholder)
        },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(
                    id = icons[icon]),
                contentDescription = label
            )
        }

    )

}