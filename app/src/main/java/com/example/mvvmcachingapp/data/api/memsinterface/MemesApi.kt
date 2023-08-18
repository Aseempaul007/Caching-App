package com.example.mvvmcachingapp.data.api.memsinterface

import com.example.mvvmcachingapp.data.api.model.Memes
import retrofit2.Response
import retrofit2.http.GET

interface MemesApi {

    @GET("/get_memes")
    suspend fun getAllMemes(): Response<Memes>

}