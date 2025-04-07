package com.example.hero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.hero.ui.theme.HeroTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val items = listOf("home", "profile")

    HeroTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Drawer Item 1")
                    Text("Drawer Item 2")
                }
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Hero App") },
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch { drawerState.open() }
                            }) {
                                Icon(Icons.Default.Menu, contentDescription = "Menu")
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) { Text("+") }
                },
                bottomBar = {
                    NavigationBar {
                        items.forEach { screen ->
                            NavigationBarItem(
                                icon = {
                                    Icon(
                                        imageVector = if (screen == "home") Icons.Default.Home else Icons.Default.Person,
                                        contentDescription = screen
                                    )
                                },
                                label = {
                                    Text(screen.replaceFirstChar { it.uppercase() })
                                },
                                selected = navController.currentDestination?.route == screen,
                                onClick = { navController.navigate(screen) }
                            )
                        }
                    }
                }
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.padding(paddingValues)
                ) {
                    composable("home") { HomeScreen() }
                    composable("profile") { ProfileScreen() }
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Greeting(name = "Android", modifier = Modifier.padding(12.dp))
                GreetingPreview()
            }
            UserPhoto()
            Spacer(Modifier.height(10.dp))
            Info(name = "Santosh Adhikari")
        }
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 12.dp)) {
        Text("Welcome to the Profile Screen")
    }
}

@Composable
private fun UserPhoto() {
        AsyncImage(
            model = "https://i.pinimg.com/736x/3b/91/19/3b9119ea93dc62c79c2a062d09f7e59c.jpg",
            contentDescription = "Image from URL", // Optional, but good for accessibility
            modifier = Modifier.size(200.dp), // Adjust size as needed
            contentScale = ContentScale.Crop,
        )

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Composable
fun GreetingPreview() {
    Text("Kotlin is very frustrating", modifier = Modifier.padding(10.dp))
}

@Composable
fun Info(name: String) {
    Box(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("User Name: $name")
    }
}
