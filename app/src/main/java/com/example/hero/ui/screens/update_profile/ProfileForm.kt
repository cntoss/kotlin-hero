package com.example.hero.ui.screens.update_profile

import ProfileViewModel
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.hero.ui.data.local.model.LocalUser

@Composable
fun ProfileForm(navController: NavController, viewModel: ProfileViewModel) {
    val context = LocalContext.current
    val user = viewModel.profileState.value

    val name = remember { mutableStateOf(user?.name ?: "") }
    val email = remember { mutableStateOf( user?.email ?: "") }
    val genderOptions = listOf("Male", "Female", "Other")
    val gender = remember { mutableStateOf(user?.gender ?: "Male") }
    val dob = remember { mutableStateOf(user?.dob ?:"") }

    val selectedImageUri = remember { mutableStateOf<Uri?>( user?.profileImageUri?.let { Uri.parse(it) } ) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedImageUri.value = it
            }
        }

    val showDatePicker = remember { mutableStateOf(false) }

    if (showDatePicker.value) {
        val calender = Calendar.getInstance()
        DatePickerDialog(
            context,
            { _, year, month, datOfMonth ->
                dob.value = "$datOfMonth/${month + 1}/$year"
                showDatePicker.value = false
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Name") })

        OutlinedTextField(value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") })

        // Gender Dropdown
        var expanded by remember { mutableStateOf(false) }
        OutlinedTextField(value = gender.value,
            onValueChange = {},
            label = { Text("Gender") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true })
        DropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            genderOptions.forEach {
                DropdownMenuItem(onClick = {
                    gender.value = it
                    expanded = false
                }, text = { Text(it) })
            }
        }

        //Date Picker
        OutlinedTextField(
            value = dob.value,
            onValueChange = {},
            readOnly = true,
            label = { Text("Date of Birth") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { { showDatePicker.value = true } }
        )

        //Image Picker
        selectedImageUri.value?.let {
            Image(
                painter = rememberAsyncImagePainter(it), contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(
                        100.dp
                    )
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            ) ?: Text("No Image Selected")
        }

        Button(onClick = { launcher.launch("image/*") }) { }

        //Submission
        Button(onClick = {
            val localUser =
                LocalUser(
                    name = name.value,
                    email = email.value,
                    gender = gender.value,
                    dob = dob.value,
                    profileImageUri = selectedImageUri.value?.path
                )
            viewModel.saveUser(localUser)
            navController.popBackStack()

        }) { Text("Submit") }
    }
}