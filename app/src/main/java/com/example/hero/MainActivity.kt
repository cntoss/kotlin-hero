package com.example.hero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.hero.ui.screens.HomeScreen
import com.example.hero.ui.screens.ProfileScreen
import com.example.hero.ui.screens.users.UsersScreen
import com.example.hero.ui.theme.HeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainApp() {
    val navController = rememberNavController()
    val navItems = listOf("home","users", "profile")

    HeroTheme {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        navItems.forEach { screen ->
                            NavigationBarItem(
                                icon = {
                                    Icon(
                                        imageVector = if (screen == "home") Icons.Default.Home
                                        else if (screen == "users") Icons.Default.Person
                                        else Icons.Default.AccountCircle,
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
                    composable("users") { UsersScreen() }
                    composable("profile") { ProfileScreen() }
                }
            }
        }

}


