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
fun Slider3Screen() {
    val minPrice = 0
    val maxPrice = 10000
    var selectedMinPrice by remember { mutableStateOf(minPrice) }
    var selectedMaxPrice by remember { mutableStateOf(maxPrice) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выберите диапазон цены товара",
            fontSize = 16.sp
        )
        Slider(
            value = selectedMinPrice.toFloat(),
            onValueChange = { newValue ->
                selectedMinPrice = newValue.toInt()
            },
            valueRange = minPrice.toFloat()..maxPrice.toFloat(),
            steps = (maxPrice - minPrice),
            modifier = Modifier.fillMaxWidth()
        )
        Slider(
            value = selectedMaxPrice.toFloat(),
            onValueChange = { newValue ->
                selectedMaxPrice = newValue.toInt()
            },
            valueRange = minPrice.toFloat()..maxPrice.toFloat(),
            steps = (maxPrice - minPrice),
            modifier = Modifier.fillMaxWidth(),

        )

        Text(
            text = "$selectedMinPrice - $selectedMaxPrice",
            fontSize = 20.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Slider3ScreenPreview() {
    Slider3Screen()
}