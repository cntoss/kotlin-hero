package com.example.hero.ui.screens.users

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hero.ui.data.remote.api.ApiClient
import com.example.hero.ui.data.remote.model.User
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {

    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users

    private val _loading = mutableStateOf(true)
    val loading: State<Boolean> = _loading

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getUsers()
                _users.value = response.data
            } catch (e: Exception) {
                Log.e("UsersVM", "Failed: ${e.message}")
            } finally {
                _loading.value = false
            }
        }
    }
}

