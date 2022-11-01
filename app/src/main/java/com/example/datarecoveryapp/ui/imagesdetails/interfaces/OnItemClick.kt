package com.example.datarecoveryapp.ui.imagesdetails.interfaces

import com.example.datarecoveryapp.ui.imagesdetails.model.ImageFile
import java.io.File

interface OnItemClick {
    fun onClick(imageFile: ImageFile)
}