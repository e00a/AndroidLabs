package com.mdk0103.labwork17.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Slider2Screen() {
    val retentionOptions = listOf(1, 3, 5, 7)
    var selectedRetention by remember { mutableStateOf(7) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выберите срок хранения файлов",
            fontSize = 16.sp
        )
        Row (verticalAlignment = Alignment.CenterVertically,) {
            Slider(
                value = selectedRetention.toFloat(),
                onValueChange = { newValue ->
                    selectedRetention = newValue.toInt()
                },
                valueRange = retentionOptions.first().toFloat()..retentionOptions.last().toFloat(),
                steps = retentionOptions.size/2,
                modifier = Modifier.width(200.dp)
            )
            Text(
                text = "$selectedRetention дней",
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Slider2ScreenPreview() {
    Slider2Screen()
}