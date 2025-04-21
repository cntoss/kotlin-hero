package com.example.hero.ui.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hero.ui.data.local.model.LocalUser

@Dao
interface LocalUseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocalUser(user: LocalUser)

    @Query("SELECT * FROM local_user WHERE id = 1")
    suspend fun getLocalUser(): LocalUser?
}