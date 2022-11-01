package com.example.datarecoveryapp.ui.home.data

import android.util.Log
import java.io.File

class GetVideosData {
    val videosList = mutableListOf<File>()
    fun findVideos(path: File): List<File> {
        val filesList=path.listFiles()
        if(filesList!=null){
            filesList.forEach {
                if(it.isDirectory){
                    findVideos(it)
                }
                else{
                    if(it.name.endsWith(".mp4")||it.name.endsWith(".mkv")){
                        videosList.add(it)
                    }
                }
            }
        }
        Log.d("TAGCHECK", "findVideos: ${videosList.toString()}")
        return videosList
    }

}