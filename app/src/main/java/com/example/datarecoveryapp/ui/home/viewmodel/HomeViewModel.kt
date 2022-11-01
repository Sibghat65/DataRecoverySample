package com.example.datarecoveryapp.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datarecoveryapp.ui.home.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) :ViewModel() {
    val imagesList = MutableLiveData<List<File>>()
    val videosList=MutableLiveData<List<File>>()
    val audiosList=MutableLiveData<List<File>>()
    fun getAllImages()
    {
        viewModelScope.launch(Dispatchers.IO) {
            imagesList.postValue(repository.getImages())
        }
    }
    fun getAllVideos(){
        viewModelScope.launch(Dispatchers.IO){
            videosList.postValue(repository.getVideos())
        }
    }
    fun getAllAudios(){
        viewModelScope.launch(Dispatchers.IO){
            audiosList.postValue(repository.getAudios())
        }
    }




}