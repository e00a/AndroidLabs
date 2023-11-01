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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TextField
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isAgreed by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Registration", modifier = Modifier.padding(bottom = 16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            singleLine = true,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            singleLine = true,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") },
            singleLine = true,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = isAgreed,
                onCheckedChange = { isAgreed = it }
            )
            Text(
                text = "Я согласен на обработку персональных данных",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Button(
            onClick = {  },
            enabled = isAgreed,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Регистрация")
        }

        Text(
            text = "Select your languages:",
            modifier = Modifier.padding(bottom = 8.dp)
        )

//        val languages = listOf(
//            LanguageItem("English"),
//            LanguageItem("Spanish"),
//            LanguageItem("French"),
//            LanguageItem("German"),
//            LanguageItem("Russian")
//        )
//
//        languages.forEach { language ->
//            Row(
//                modifier = Modifier.toggleable(
//                    value = language.isSelected,
//                    onValueChange = { language.isSelected = it }
//                )
//            ) {
//                Checkbox(
//                    checked = language.isSelected,
//                    onCheckedChange = { language.isSelected = it },
//                    modifier = Modifier.padding(end = 8.dp)
//                )
//                Text(text = language.language)
//            }
//        }
    }
}



@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}