package com.example.mvvmcachingapp.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmcachingapp.data.api.model.Meme

@Database(
    entities =[Meme::class],
    version = 1
)
abstract class MemeDb: RoomDatabase() {
    abstract fun memeDao(): MemeDao
}