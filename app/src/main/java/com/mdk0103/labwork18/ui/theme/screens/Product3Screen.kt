package com.mdk0103.labwork18.ui.theme.screens

import androidx.compose.runtime.Composable
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Product3Screen() {
    var isAdded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Молоко")
        Text(text = "Цена: 100р")
    }

    ExtendedFloatingActionButton(
        onClick = { isAdded = !isAdded },
        text = {
            if (isAdded) {
                Text(text = "Удалить")
            } else {
                Text(text = "Добавить")
            }
        },
        icon = {
            if (isAdded) {
                Icon(Icons.Default.Delete, contentDescription = "Удалить")
            } else {
                Icon(Icons.Default.Add, contentDescription = "Добавить")
            }
        }
    )

}

