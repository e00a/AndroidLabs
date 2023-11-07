package com.mdk0103.labwork18

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import com.mdk0103.labwork18.ui.theme.LabWork18Theme
import com.mdk0103.labwork18.ui.theme.screens.*

var current by mutableStateOf("AuthorizationScreen")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabWork18Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Menu()
                        when (current) {
                            "AuthorizationScreen" -> AuthorizationScreen()
                            "ProductScreen" -> ProductScreen()
                            "ButtonsScreen" -> ButtonsScreen()
                            "StyleProductScreen" -> StyleProductScreen()
                            "OrderedProductScreen" -> OrderedProductScreen()
                            "DataScreen" -> DataScreen()
                            "Product3Screen" -> Product3Screen()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Menu(modifier: Modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { current = "AuthorizationScreen" },
                    modifier = Modifier
                ) {
                    Text(
                        text = "Task 1.1",
                    )
                }
                Button(
                    onClick = { current = "ProductScreen" },
                    modifier = Modifier
                )
                {
                    Text(
                        text = "Task 1.2",
                    )
                }
                Button(
                    onClick = { current = "ButtonsScreen" },
                )
                {
                    Text(
                        text = "Task 2",
                    )
                }
                Button(
                    onClick = { current = "StyleProductScreen" },
                )
                {
                    Text(
                        text = "Task 3",
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { current = "OrderedProductScreen" },
                    modifier = Modifier
                )
                {
                    Text(
                        text = "Task 4",
                        modifier = Modifier
                    )
                }
                Button(
                    onClick = { current = "DataScreen" },
                    modifier = Modifier
                )
                {
                    Text(
                        text = "Task 5",
                        modifier = Modifier
                    )
                }
                Button(
                    onClick = { current = "Product3Screen" },
                    modifier = Modifier
                )
                {
                    Text(
                        text = "Task 5.2",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
