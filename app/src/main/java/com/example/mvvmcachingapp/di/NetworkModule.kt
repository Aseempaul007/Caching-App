package com.example.mvvmcachingapp.di

import android.content.Context
import androidx.room.Room

import com.example.mvvmcachingapp.data.api.memsinterface.MemesApi
import com.example.mvvmcachingapp.data.local.dao.MemeDao
import com.example.mvvmcachingapp.data.local.dao.MemeDb
import com.example.mvvmcachingapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getMemesApi(retrofit: Retrofit): MemesApi{
        return retrofit.create(MemesApi::class.java)
    }

    @Provides
    @Singleton
    fun getMemeDb(@ApplicationContext context: Context): MemeDb{
        synchronized(this){
            return Room.databaseBuilder(
                context,
                MemeDb::class.java,
                "memedb"
            ).build()
        }
    }

    @Provides
    @Singleton
    fun getMemeDao(memeDb: MemeDb): MemeDao {
        return memeDb.memeDao()
    }


}