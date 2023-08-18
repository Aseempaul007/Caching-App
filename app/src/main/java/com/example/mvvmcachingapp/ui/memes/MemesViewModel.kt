package com.example.mvvmcachingapp.ui.memes

import androidx.lifecycle.ViewModel
import com.example.mvvmcachingapp.data.api.model.Meme
import com.example.mvvmcachingapp.data.api.model.Memes
import com.example.mvvmcachingapp.repository.MemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MemesViewModel @Inject constructor(val memeRepository: MemeRepository): ViewModel() {

    suspend fun getMemes(): List<Meme>{
        return memeRepository.getMemes()
    }

}