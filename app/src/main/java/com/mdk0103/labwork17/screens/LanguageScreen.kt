package com.mdk0103.labwork17.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.ui.Alignment

@Preview
@Composable
fun LanguageScreen() {
    val languages = listOf("English", "Español", "Français", "Deutsch", "Русский")
    var selectedLanguage by remember { mutableStateOf(languages[0]) }
    Column(
        modifier = Modifier
    ) {
        Text(text = "Выберете язык", modifier = Modifier)
        languages.forEach { language ->
            LanguageItem(language = language,
                isSelected = language == selectedLanguage,
                onLanguageSelected = { selectedLanguage = language })
        }
        Text(
            text = "Selected Language: ${selectedLanguage}", modifier = Modifier
        )
    }
}

@Composable
fun LanguageItem(
    language: String, isSelected: Boolean, onLanguageSelected: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .selectable(selected = isSelected, onClick = onLanguageSelected)
            .fillMaxWidth()
    ) {
        RadioButton(selected = isSelected, onClick = onLanguageSelected)

        Text(text = language)
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageScreenPreview() {
    LanguageScreen()
}