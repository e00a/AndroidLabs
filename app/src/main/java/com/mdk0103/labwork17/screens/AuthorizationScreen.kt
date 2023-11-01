package com.mdk0103.labwork17.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdk0103.labwork17.current

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreen(modifier: Modifier = Modifier) {
    var login by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}
    var visible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Экран авторизации")

        OutlinedTextField(
            value = login,
            onValueChange = {login = it},
            label = { Text(text = "Логин") },
            singleLine = true,
        )

        OutlinedTextField(
            password,
            {password = it},
            label = { Text(text = "Пароль") },
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
            Text("$login, вы авторизованы")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorizationScreenPreview() {
    AuthorizationScreen()
}