package com.example.datarecoveryapp.ui.home.data

import android.net.Uri
import android.util.Log
import java.io.File

class GetImagesData {
    val imagesList = mutableListOf<File>()
    fun findImages(file: File):List<File>{
        val filesList=file.listFiles()
        if(filesList!=null){
            filesList.forEach {
                if(it.isDirectory){
                    findImages(it)
                }
                else{
                    if(it.name.endsWith(".jpg")||it.name.endsWith(".png")||it.name.endsWith(".gif")){
                        imagesList.add(it)
                    }
                }
            }
        }

        return imagesList
    }
}