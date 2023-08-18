package com.example.mvvmcachingapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcachingapp.data.api.model.Meme
import com.example.mvvmcachingapp.data.api.model.Memes

@Dao
interface MemeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(listOfMeme: List<Meme>)

    @Query("SELECT * FROM memes")
    suspend fun showAllMemes(): List<Meme>


}