package com.example.mvvmcachingapp.repository

import android.content.Context
import com.example.mvvmcachingapp.data.api.memsinterface.MemesApi
import com.example.mvvmcachingapp.data.api.model.Meme
import com.example.mvvmcachingapp.data.local.dao.MemeDao
import com.example.mvvmcachingapp.util.Constants.isOnline
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject

class MemeRepository @Inject constructor(
    private val memesApi: MemesApi,
    private val memeDao: MemeDao,
    @ApplicationContext private val context: Context) {

    suspend fun getMemes(): List<Meme>{

        if(isOnline(context)){
            val result = memesApi.getAllMemes()
            memeDao.insertMeme(result.body()?.data!!.memes)
            return result.body()!!.data.memes
        }else {
            return memeDao.showAllMemes()
        }

    }




}