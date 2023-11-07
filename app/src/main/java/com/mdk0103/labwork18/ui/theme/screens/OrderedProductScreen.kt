package com.mdk0103.labwork18.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdk0103.labwork18.R

@Composable
fun OrderedProductScreen() {
    var quantity by remember { mutableStateOf(1) }
    val price = 100

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Молоко",
        )
        Text(
            text = "Цена: $price",
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            IconButton(
                onClick = {
                    if (quantity > 1) {
                        quantity--
                    }
                },
                enabled = quantity > 1,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus2),
                    contentDescription = "Minus",
                    tint = Color.Red
                )
            }

            Text(
                text = "Количество: $quantity",
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            IconButton(
                onClick = {
                    if (quantity < 10) {
                        quantity++
                    }
                },
                enabled = quantity < 10,
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Информация о приложении",tint = Color.Green)
            }
        }

        Text(
            text = "Итого: ${quantity * price}",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}