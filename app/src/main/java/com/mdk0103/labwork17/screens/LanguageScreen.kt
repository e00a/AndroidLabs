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
import androidx.compose.foundation.selection.selectable
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
fun LanguageScreen(modifier: Modifier = Modifier) {
    val selectedLanguage = remember { mutableStateOf(LanguageOption.ENGLISH) }

    Column(Modifier.selectableGroup()) {
        RadioButtonOption(
            option = LanguageOption.ENGLISH,
            selectedOption = selectedLanguage.value,
            onOptionSelected = { selectedLanguage.value = it }
        )
        RadioButtonOption(
            option = LanguageOption.SPANISH,
            selectedOption = selectedLanguage.value,
            onOptionSelected = { selectedLanguage.value = it }
        )
        RadioButtonOption(
            option = LanguageOption.FRENCH,
            selectedOption = selectedLanguage.value,
            onOptionSelected = { selectedLanguage.value = it }
        )
        RadioButtonOption(
            option = LanguageOption.GERMAN,
            selectedOption = selectedLanguage.value,
            onOptionSelected = { selectedLanguage.value = it }
        )
        RadioButtonOption(
            option = LanguageOption.ITALIAN,
            selectedOption = selectedLanguage.value,
            onOptionSelected = { selectedLanguage.value = it }
        )
    }
    Text(
        text = "Выбранный язык: ${selectedLanguage.value.label}",
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Composable
fun RadioButtonOption(
    option: LanguageOption,
    selectedOption: LanguageOption,
    onOptionSelected: (LanguageOption) -> Unit
) {
    Row(Modifier.selectable(
        selected = (option == selectedOption),
        onClick = { onOptionSelected(option) }
    )) {
        RadioButton(
            selected = (option == selectedOption),
            onClick = { onOptionSelected(option) },
        )
        Text(
            text = option.label,
            modifier = Modifier
        )
    }
}

enum class LanguageOption(val label: String) {
    ENGLISH("English"),
    SPANISH("Spanish"),
    FRENCH("French"),
    GERMAN("German"),
    ITALIAN("Italian")
}

@Preview(showBackground = true)
@Composable
fun LanguageScreenPreview() {
    LanguageScreen()
}