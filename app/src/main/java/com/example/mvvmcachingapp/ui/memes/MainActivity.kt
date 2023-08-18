package com.example.mvvmcachingapp.ui.memes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcachingapp.R
import com.example.mvvmcachingapp.data.api.memsinterface.MemesApi
import com.example.mvvmcachingapp.data.local.dao.MemeDao
import com.example.mvvmcachingapp.databinding.ActivityMainBinding
import com.example.mvvmcachingapp.util.Constants.MYTAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var memesViewModel: MemesViewModel

    lateinit var mainBinding: ActivityMainBinding

    @Inject
    lateinit var memesApi: MemesApi

    @Inject
    lateinit var memeDao: MemeDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        memesViewModel= ViewModelProvider(this).get(MemesViewModel::class.java)
        mainBinding.button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d(MYTAG,memesViewModel.getMemes().toString())
                Log.d(MYTAG,memeDao.showAllMemes().toString())
            }
        }





    }
}