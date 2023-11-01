package com.mdk0103.labwork17.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdk0103.labwork17.current

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val maxCharacters = 30
    var text by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                isValid = it.length <= maxCharacters
            },
            trailingIcon = {
                if (!isValid) {
                    Icon(Icons.Default.Warning, contentDescription = null)
                }
            },
            placeholder = { Text(text = "О себе") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 5,
            isError = !isValid,
            supportingText = {if (!isValid) {
                Text(
                    text = "Превышена длина строки",
                    modifier = Modifier.padding(top = 4.dp)
                )
            }},
        )
        Text(
            text = "Количество символов: ${text.length}/$maxCharacters",
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}