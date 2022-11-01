package com.example.datarecoveryapp.ui.home.repository

import android.os.Environment
import com.example.datarecoveryapp.ui.home.data.GetAudiosData
import com.example.datarecoveryapp.ui.home.data.GetImagesData
import com.example.datarecoveryapp.ui.home.data.GetVideosData
import java.io.File
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val getImagesData: GetImagesData,
    private val getVideosData: GetVideosData,
    private val getAudiosData: GetAudiosData) {

    suspend fun getImages(): MutableList<File> {
        return getImagesData.findImages(Environment.getExternalStorageDirectory()) as MutableList<File>
    }

    suspend fun getVideos():MutableList<File>{
        return getVideosData.findVideos(Environment.getExternalStorageDirectory()) as MutableList<File>
    }
    suspend fun getAudios():MutableList<File>{
        return getAudiosData.findAudios(Environment.getExternalStorageDirectory()) as MutableList<File>
    }


}