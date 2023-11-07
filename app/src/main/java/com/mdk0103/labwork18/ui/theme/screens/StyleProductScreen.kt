package com.mdk0103.labwork18.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StyleProductScreen() {
    var isAdded by remember { mutableStateOf(false) }
    val buttonText = if (isAdded) "Перейти в корзину" else "Добавить в корзину"
    val buttonBackground = if (isAdded) Color.Green else Color.Blue

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Молоко",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Цена: 100р",
            modifier = Modifier.padding(bottom = 16.dp)
        )



        Button(
            onClick = { isAdded = !isAdded },
            modifier = Modifier
                .padding(bottom = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                    containerColor = buttonBackground
        ),

        ) {
            Text(text = buttonText)
        }
    }
}
