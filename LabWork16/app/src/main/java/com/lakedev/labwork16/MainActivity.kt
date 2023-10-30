package com.lakedev.labwork16

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lakedev.labwork16.ui.theme.LabWork16Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabWork16Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Task3()
                    }
                }
            }
        }
    }
}

@Composable
fun Task2(modifier: Modifier = Modifier) {
    Column {
        Button(onClick = { }) {
            Text(text = stringResource(R.string.find))
        }

        Button(onClick = { }) {
            Text(text = stringResource(R.string.ok))
        }

        Button(onClick = { }) {
            Text(text = stringResource(R.string.enter))
        }

        Button(onClick = { }) {
            Text(text = stringResource(R.string.register))
        }
        Button(onClick = { }) {
            Text(text = stringResource(R.string.search_en))
        }

        Button(onClick = { }) {
            Text(text = stringResource(R.string.ok_en))
        }

        Button(onClick = { }) {
            Text(text = stringResource(R.string.enter_en))
        }

        Button(onClick = { }) {
            Text(text = stringResource(R.string.register_en),fontFamily = comfortaa,)
        }

        val seasonString = stringArrayResource(R.array.seasons).joinToString()
        Text(text = seasonString,fontFamily = comfortaa,)
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Preview() {
    LabWork16Theme {
        Task2()
    }
}

@Composable
fun Task3(modifier: Modifier = Modifier) {
    Column {
        TimeText(hours = 1, minutes = 1)
        TimeText(hours = 2, minutes = 2)
        TimeText(hours = 5, minutes = 5)
    }
}

@Composable
fun TimeText(hours: Int, minutes: Int, modifier: Modifier = Modifier) {
    val resources = LocalContext.current.resources
    val time = "${
        resources.getQuantityString(
            R.plurals.hours,
            hours,
            hours
        )
    } : ${resources.getQuantityString(R.plurals.minutes, minutes, minutes)}"

    Text(text = time, fontFamily = comfortaa,)
}

@Preview(showBackground = true, locale = "ru")
@Composable
fun Task3Preview() {
    LabWork16Theme {
        Task3()
    }
}

@Composable
fun Task4(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.row_padding))
    ) {
        Button(
            modifier = Modifier
                .width(dimensionResource(R.dimen.button_width))
                .height(dimensionResource(R.dimen.button_height))
                .padding(dimensionResource(R.dimen.button_padding)),
            onClick = { }
        ) {
            Text(text = "text", fontFamily = comfortaa, fontSize = 28.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task4Preview() {
    LabWork16Theme {
        Task4()
    }
}

@Composable
fun Task5(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                dimensionResource(R.dimen.row_padding)
            )
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img1),
            contentDescription = "image with bg",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(16.dp)
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(16.dp)
                .clip(CircleShape)
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Inside
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.FillHeight
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "image no bg",
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.None
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task5Preview() {
    LabWork16Theme {
        Task5()
    }
}