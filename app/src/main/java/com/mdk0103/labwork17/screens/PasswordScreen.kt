package com.mdk0103.labwork17.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordScreen() {
    var pinCode by remember { mutableStateOf("") }
    var remainingAttempts by remember { mutableStateOf(3) }
    val correctPinCode by remember { mutableStateOf(1111) }
    var isCorrectPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        OutlinedTextField(
            value = pinCode,
            onValueChange = { text ->
                if (text.length <= 4) {
                    pinCode = text
                }
            },
            placeholder = { Text(text = "Введите пин-код") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            maxLines = 1,
            modifier = Modifier.padding(vertical = 8.dp),
            enabled = remainingAttempts > 0
        )

        Text(
            text = "Попытки: $remainingAttempts",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = {
                if (remainingAttempts > 0) {
                    if (pinCode.toIntOrNull() == correctPinCode) {
                        remainingAttempts = 3
                        pinCode = ""
                        isCorrectPassword = true
                    } else {
                        remainingAttempts--
                        pinCode = ""
                        isCorrectPassword = false
                    }
                }
            },
            enabled = remainingAttempts > 0
        ) {
            Text(text = "Подтвердить")
        }

        if (remainingAttempts == 0) {
            Text(text = "Попытки исчерпаны", modifier = Modifier.padding(top = 8.dp))
        }
        if (isCorrectPassword) {
            Text(text = "Верный пароль", modifier = Modifier.padding(bottom = 16.dp))
        }
        else if (isCorrectPassword || remainingAttempts < 3)
            Text(text = "Не Верный пароль", modifier = Modifier.padding(bottom = 16.dp))
    }

}

@Composable
fun ShowMessage(message: String) {
    Text(text = message, modifier = Modifier.padding(bottom = 16.dp))
}

@Preview(showBackground = true)
@Composable
fun PasswordScreenPreview() {
    PasswordScreen()
}