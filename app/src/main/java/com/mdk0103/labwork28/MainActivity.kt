package com.mdk0103.labwork28

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdk0103.labwork28.ui.theme.LabWork28Theme
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabWork28Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Add.route) {
        composable(route = Screens.Add.route) {
            NewUserScreen(context = LocalContext.current, navController)
        }
        composable(route = Screens.Read.route) {
            UsersScreen(context = LocalContext.current)
        }
        composable(route = Screens.Edit.route) {
            EditUserScreen(context = LocalContext.current)
        }
        composable(route = Screens.Delete.route) {
            DeleteUserScreen(context = LocalContext.current)
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun NewUserScreen(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    var login by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf(0)
    }
    var dbHelper: DbHelper = DbHelper(context)

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логин") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = age.toString(),
            onValueChange = { age = it.toIntOrNull() ?: 0 },
            label = { Text("Возраст") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                dbHelper.addNewUser(User(login, password, age))
                Toast.makeText(context, "User Added to Database", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Add user")
        }

        Button(onClick = {
            navController.navigate(Screens.Read.route)
        }) {
            Text(text = "Show users", color = Color.White)
        }
        Button(onClick = {
            navController.navigate(Screens.Edit.route)
        }) {
            Text(text = "Edit user", color = Color.White)
        }
        Button(onClick = {
            navController.navigate(Screens.Delete.route)
        }) {
            Text(text = "Delete user", color = Color.White)
        }
    }
}

@Composable
fun UsersScreen(context: Context, modifier: Modifier = Modifier) {
    lateinit var courseList: List<User>
    courseList = ArrayList<User>()

    val dbHandler: DbHelper = DbHelper(context);
    courseList = dbHandler.readUsers()!!

    LazyColumn {
        itemsIndexed(courseList) { index, item ->
            Card(
                modifier = Modifier.padding(8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = courseList[index].login,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Пароль : " + courseList[index].password,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Возраст : " + courseList[index].age,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))


                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditUserScreen(context: Context,
                   modifier: Modifier = Modifier,) {

    var dbHelper: DbHelper = DbHelper(context)

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Login") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") }
        )
        Button(onClick = {
            dbHelper.editUser(login, password, age.toIntOrNull())
            Toast.makeText(context, "User Edited", Toast.LENGTH_SHORT).show()
        }) {
            Text("Change")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteUserScreen(context: Context,
                   modifier: Modifier = Modifier,) {

    var dbHelper: DbHelper = DbHelper(context)

    var login by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Login") }
        )
        Button(onClick = {
            dbHelper.deleteUser(login,)
            Toast.makeText(context, "User deleted", Toast.LENGTH_SHORT).show()
        }) {
            Text("Delete")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork28Theme {
        Greeting("Android")
    }
}