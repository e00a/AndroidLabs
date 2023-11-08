package com.mdk0103.labwork19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdk0103.labwork19.ui.theme.LabWork19Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabWork19Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    UserMessageItem("user1", "message")

                }
            }
        }
    }
}

@Composable
fun UserMessageItem(
    userName: String, message: String
) {
    Row(
        modifier = Modifier.padding(bottom = 16.dp),

        ) {
        Icon(
            Icons.Filled.Person, contentDescription = "User Icon", modifier = Modifier.size(60.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = userName, modifier = Modifier, fontWeight = FontWeight.Bold
            )
            Text(
                text = message, modifier = Modifier
            )
        }
    }
}

//Task1.1
@Preview(showBackground = true)
@Composable
fun UserMessagePreview() {
    LabWork19Theme {
        UserMessageItem("user1", "message")
    }
}

@Composable
fun MessageList() {
    LazyColumn {
        items(40) { i ->
            UserMessageItem("$i имя", "сообщение $i")
        }
    }
}

//Task 1.2
@Preview(showBackground = true)
@Composable
fun MessageListPreview() {
    LabWork19Theme {
        MessageList()
    }
}

@Composable
fun ListOfMessageList() {
    val messageList = listOf(
        "Добавить",
        "сообщение1",
        "сообщение2",
        "сообщение3",
        "сообщение4",
        "сообщение5",
        "сообщение6",
        "сообщение7",
        "сообщение8",
        "сообщение9",
    )
    LazyColumn {
        items(messageList) { item ->
            UserMessageItem("имя", item)
        }
    }
}

//Task 1.3
@Preview(showBackground = true)
@Composable
fun ListOfMessageListPreview() {
    LabWork19Theme {
        ListOfMessageList()
    }
}

//Task2
@Composable
fun StoryUserItem(username: String) {
    Column(
        modifier = Modifier.padding(9.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Filled.AccountCircle,
            contentDescription = "Story",
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = username,
            modifier = Modifier,
        )
    }
}

//Task 2.1
@Preview(showBackground = true)
@Composable
fun StoryUserItemPreview() {
    LabWork19Theme {
        StoryUserItem("User1")
    }
}

@Composable
fun StoriesList() {
    LazyRow {
        items(20) { i ->
            StoryUserItem("имя $i")
        }
    }
}

//Task 2.2
@Preview(showBackground = true)
@Composable
fun StoriesListPreview() {
    LabWork19Theme {
        StoriesList()
    }
}

@Composable
fun ListOfStoriesList() {
    val messageList = listOf(
        "имя 1",
        "имя 2",
        "имя 3",
        "имя 4",
        "имя 5",
        "имя 6",
        "имя 7",
        "имя 8",
        "имя 9",
        "имя 10",
    )

    LazyRow {
        items(messageList) { item ->
            StoryUserItem(item)
        }
    }
}

//Task 2.3
@Preview(showBackground = true)
@Composable
fun ListOfStoriesListPreview() {
    LabWork19Theme {
        ListOfStoriesList()
    }
}

//Task3
@Composable
fun ListOfMessageListButton() {
    val messageList = listOf(
        "Добавить",
        "сообщение1",
        "сообщение2",
        "сообщение3",
        "сообщение4",
        "сообщение5",
        "сообщение6",
        "сообщение7",
        "сообщение8",
        "сообщение9",
        "Добавить",
        "сообщение1",
        "сообщение2",
        "сообщение3",
        "сообщение4",
        "сообщение5",
        "сообщение6",
        "сообщение7",
        "сообщение8",
        "сообщение9",
    )
    val listState = rememberLazyListState()
    val showButton = remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyColumn(
            state = listState, modifier = Modifier.weight(1f)
        ) {
            items(messageList) { item ->
                UserMessageItem("имя", item)
            }
        }
        Button(
            onClick = {
                coroutineScope.launch {
                    listState.scrollToItem(0)
                }
            },
            enabled = showButton.value,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Text("В начало")
        }
    }

}

//Task 3
@Preview(showBackground = true)
@Composable
fun ListOfMessageListButtonPreview() {
    LabWork19Theme {
        ListOfMessageListButton()
    }
}

//Task 4.1
@Composable
fun PhotosVerticalGrid() {
    val photosList = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img,
        R.drawable.img1,
        R.drawable.img,
        R.drawable.img3,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img3,
        R.drawable.img,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img,
        R.drawable.img3,
        R.drawable.img1,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), contentPadding = PaddingValues(9.dp)
    ) {
        items(photosList) { photo ->
            Image(
                painter = painterResource(id = photo),
                contentDescription = null,
                modifier = Modifier.padding(3.dp).aspectRatio(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosVerticalGridPreview() {
    LabWork19Theme {
        PhotosVerticalGrid()
    }
}

//Task 4.2
@Composable
fun PhotosVerticalGrid2() {
    val photosList = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img,
        R.drawable.img1,
        R.drawable.img,
        R.drawable.img3,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img3,
        R.drawable.img,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img,
        R.drawable.img3,
        R.drawable.img1,
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(photosList) { photo ->
            Image(
                painter = painterResource(id = photo),
                contentDescription = null,
                modifier = Modifier.padding(3.dp).aspectRatio(1f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosVerticalGrid2Preview() {
    LabWork19Theme {
        PhotosVerticalGrid2()
    }
}

//Task5
@Composable
fun ProductItem(product: Product) {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = null,
            modifier = Modifier
        )
        Text(
            text = product.name, modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = product.price, modifier = Modifier.padding(top = 4.dp)
        )
    }
}

//Task5.1
@Composable
fun ProductHorizontalGrid() {
    val productsList = listOf(
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
    )

    LazyHorizontalGrid(
        modifier = Modifier.height(400.dp),
        rows = GridCells.Fixed(2),
    ) {
        items(productsList) { product ->
            ProductItem(product)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHorizontalGridPreview() {
    LabWork19Theme {
        ProductHorizontalGrid()
    }
}

//Task5.2
@Composable
fun ProductHorizontalGrid2() {
    val productsList = listOf(
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
        Product(R.drawable.img1, "Product 1", "$10"),
        Product(R.drawable.img2, "Product 2", "$15"),
        Product(R.drawable.img3, "Product 3", "$20"),
    )

    LazyHorizontalGrid(
        modifier = Modifier.height(500.dp),
        rows = GridCells.Adaptive(150.dp),
    ) {
        items(productsList) { product ->
            ProductItem(product)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHorizontalGrid2Preview() {
    LabWork19Theme {
        ProductHorizontalGrid2()
    }
}