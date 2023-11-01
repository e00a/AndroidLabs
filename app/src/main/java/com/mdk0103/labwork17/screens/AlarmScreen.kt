package com.mdk0103.labwork17.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlarmScreen() {
    val alarms = listOf("6:00", "8:00", "9:30")
    val enabledAlarms = remember { mutableStateListOf(false, false, false) }

    Column {
        alarms.forEachIndexed { index, alarm ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(9.dp)
            ) {
                Text(text = alarm, modifier = Modifier.width(200.dp),)
                Text(
                    text = if (enabledAlarms[index]) "включен" else "отключен",
                    modifier = Modifier.padding(9.dp).width(100.dp)
                )
                Switch(
                    checked = enabledAlarms[index],
                    onCheckedChange = { enabledAlarms[index] = it }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmScreenPreview() {
    AlarmScreen()
}