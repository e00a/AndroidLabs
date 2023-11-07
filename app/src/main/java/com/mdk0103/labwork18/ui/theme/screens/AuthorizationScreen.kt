package com.mdk0103.labwork18.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreen(modifier: Modifier = Modifier) {
    var login by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}
    var visible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Авторизация", )

        // Поле ввода логина
        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логин") },
            modifier = Modifier.padding(vertical = 8.dp),
            singleLine = true,
        )

        // Поле ввода пароля
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(bottom = 8.dp),
            singleLine = true,
        )

        Button(
            onClick = {
                visible = !visible
            }
        ) {
            Text(text = "Авторизация")
        }
        if (visible && password.isNotEmpty()) {
            Text("«Добро пожаловать, $login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorizationScreenPreview() {
    AuthorizationScreen()
}