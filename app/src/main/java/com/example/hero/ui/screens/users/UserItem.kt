package com.example.hero.ui.screens.users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.hero.ui.data.remote.model.User

@Composable
fun UserItem(user: User) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            AsyncImage(user.avatar,
                contentDescription = "Image from URL",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop)
            Column(Modifier.padding(start = 16.dp)) {
                Text("${user.firstName} ${user.lastName}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(user.email, color = Color.Gray, fontSize = 14.sp)
            }
        }
}