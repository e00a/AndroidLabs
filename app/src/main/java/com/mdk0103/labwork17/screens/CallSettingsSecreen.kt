package com.mdk0103.labwork17.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallSettingsScreen(modifier: Modifier = Modifier) {
    val selectedOption = remember { mutableStateOf(CallPermissionOption.ALL) }

    Column(Modifier.selectableGroup()) {
        RadioButtonOption(
            option = CallPermissionOption.ALL,
            selectedOption = selectedOption.value,
            onOptionSelected = { selectedOption.value = it }
        )
        RadioButtonOption(
            option = CallPermissionOption.MY_CONTACTS,
            selectedOption = selectedOption.value,
            onOptionSelected = { selectedOption.value = it }
        )
    }
}

@Composable
fun RadioButtonOption(
    option: CallPermissionOption,
    selectedOption: CallPermissionOption,
    onOptionSelected: (CallPermissionOption) -> Unit
) {
    val isSelected = option == selectedOption
    Row {
        RadioButton(
            selected = isSelected,
            onClick = { onOptionSelected(option) },
        )

        Text(
            text = option.label,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}


enum class CallPermissionOption(val label: String) {
    ALL("Все"), MY_CONTACTS("Мои контакты")
}

@Preview(showBackground = true)
@Composable
fun CallSettingsScreenPreview() {
    CallSettingsScreen()
}