package com.mdk0103.labwork17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdk0103.labwork17.screens.*
import com.mdk0103.labwork17.ui.theme.LabWork17Theme

var current by mutableStateOf("AuthorizationScreen")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabWork17Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Menu()
                        when (current) {
                            "AuthorizationScreen" -> AuthorizationScreen()
                            "RegistrationScreen" -> RegistrationScreen()
                            "ProfileScreen" -> ProfileScreen()
                            "SearchScreen" -> SearchScreen()
                            "PasswordScreen" -> PasswordScreen()
                            "CallSettingsScreen" -> CallSettingsScreen()
                            "LanguageScreen" -> LanguageScreen()
                            "NotificationScreen" -> NotificationScreen()
                            "AlarmScreen" -> AlarmScreen()
                            "Slider1Screen" -> Slider1Screen()
                            "Slider2Screen" -> Slider2Screen()
                            "Slider3Screen" -> Slider3Screen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Button(
                onClick = { current = "AuthorizationScreen" },
                modifier = Modifier
            ) {
                Text(
                    text = "Авторизация",
                )
            }
            Button(
                onClick = { current = "RegistrationScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Регистрация",
                )
            }
            Button(
                onClick = { current = "SearchScreen" },
            )
            {
                Text(
                    text = "Task2",
                )
            }
            Button(
                onClick = { current = "ProfileScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task3",
                    modifier = Modifier
                )
            }
            Button(
                onClick = { current = "PasswordScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task4",
                    modifier = Modifier
                )
            }
            Button(
                onClick = { current = "CallSettingsScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task6.1",
                    modifier = Modifier
                )
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { current = "LanguageScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task6.2",
                    modifier = Modifier
                )
            }
            Button(
                onClick = { current = "NotificationScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task7.1",
                    modifier = Modifier
                )
            }
            Button(
                onClick = { current = "AlarmScreen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task7.2",
                    modifier = Modifier
                )
            }

            Button(
                onClick = { current = "Slider1Screen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task8.1",
                    modifier = Modifier
                )
            }
            Button(
                onClick = { current = "Slider2Screen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task8.2",
                    modifier = Modifier
                )
            }
            Button(
                onClick = { current = "Slider3Screen" },
                modifier = Modifier
            )
            {
                Text(
                    text = "Task8.3",
                    modifier = Modifier
                )
            }
        }
    }
}