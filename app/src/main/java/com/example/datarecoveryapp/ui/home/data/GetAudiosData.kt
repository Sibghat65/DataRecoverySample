package com.example.datarecoveryapp.ui.home.data

import java.io.File

class GetAudiosData {
    val audiosList = mutableListOf<File>()
    fun findAudios(file: File):List<File>{
        val filesList=file.listFiles()
        if(filesList!=null){
            filesList.forEach {
                if(it.isDirectory){
                    findAudios(it)
                }
                else{
                    if(it.name.endsWith(".mp3")||it.name.endsWith(".wav")){
                        audiosList.add(it)
                    }
                }
            }
        }

        return audiosList
    }



}