package com.eveliina.scaffoldapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.eveliina.scaffoldapp.ui.theme.ScaffoldAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldAppTheme {
                    ScaffoldApp()
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldApp() {
    Scaffold(
        topBar = { TopAppBar { Text(text="My app") }},
        content = { Text(text="Content for home screen") },
        //bottomBar = { BottomAppBar { Text(text="Bottom bar")}}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    var expanded by remember { mutableStateOf(false)}

    TopAppBar(
        title = { Text("MyApp")},
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ){
                Icon(Icons.Filled.Menu, contentDescription =null)
            }
        },
        actions = {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropwdownMenuItem(onClick = { /*TODO*/ }) {
                    Text("Info")
                }
                DropwdownMenuItem(onClick = { /*TODO*/ }) {
                    Text("Settings")
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScaffoldAppTheme {
        ScaffoldApp()
    }
}