package com.example.hero.ui.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("local_user")
data class LocalUser(
    @PrimaryKey val id: Int = 1, // Assuming single user
    val name: String,
    val email: String,
    val gender: String,
    val dob: String,
    val profileImageUri: String?
)
