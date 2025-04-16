package com.example.hero.ui.data.remote.api

import com.example.hero.ui.data.remote.model.UserResponse
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): UserResponse
}