package com.mdk0103.labwork17.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallSettingsScreen(modifier: Modifier = Modifier) {
    val options = listOf("Все", "Мои контакты")
    var selectedOption by remember { mutableStateOf(options[0]) }
    Column(
        modifier = Modifier.selectableGroup()
    ) {
        options.forEach { option ->
            SettingsRadioButton(option = option,
                option == selectedOption,
                onOptionSelected = { selectedOption = option })
        }
    }
}

@Composable
fun SettingsRadioButton(
    option: String, isSelected: Boolean, onOptionSelected: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
    ) {
        RadioButton(selected = isSelected, onClick = onOptionSelected)

        Text(text = option)
    }
}

@Preview(showBackground = true)
@Composable
fun CallSettingsScreenPreview() {
    CallSettingsScreen()
}