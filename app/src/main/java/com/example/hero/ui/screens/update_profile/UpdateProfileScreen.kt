package com.example.hero.ui.screens.update_profile

import ProfileViewModel
import android.app.Application
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hero.ui.screens.profile.ProfileViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateProfileScreen(navController: NavController) {
    val context = LocalContext.current.applicationContext as Application

    val factory = remember { ProfileViewModelFactory(context) }
    val viewModel: ProfileViewModel = viewModel(factory = factory)
    val profile = viewModel.profileState.value
    Scaffold(topBar = { TopAppBar(title = { Text("Update Profile") }) })
    { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            ProfileForm(navController, viewModel)
        }
    }
}