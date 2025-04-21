package com.example.hero.ui.screens.profile

import ProfileViewModel
import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    val context = LocalContext.current.applicationContext as Application

    val factory = remember { ProfileViewModelFactory(context) }
    val viewModel: ProfileViewModel = viewModel(factory = factory)
    val profile = viewModel.profileState.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                actions = {
                    Button(onClick = {
                        navController.navigate("updateProfile")
                    })
                    {
                        if (profile?.name == null) Text("Add Profile")
                        else Text("Update Profile")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                Column {
                    Text("Welcome to the Profile Screen")
                    UserPhoto()
                    Spacer(Modifier.height(10.dp))
                    profile?.let {
                        Text("Name: ${it.name}")
                        Text("Email: ${it.email}")
                        Text("Gender: ${it.gender}")
                        Text("DOB: ${it.dob}")
                    } ?: Text("User Not found please update.")
                    Info(name = "Santosh Adhikari")

                }
            }
        }
    }
}

@Composable
fun Info(name: String) {
    Box(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Name: $name")
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