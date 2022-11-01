package com.example.datarecoveryapp.di


import com.example.datarecoveryapp.ui.home.data.GetAudiosData
import com.example.datarecoveryapp.ui.home.data.GetImagesData
import com.example.datarecoveryapp.ui.home.data.GetVideosData
import com.example.datarecoveryapp.ui.home.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesImagesData() =GetImagesData()
    @Provides
    @Singleton
    fun providesVideosData() =GetVideosData()
    @Provides
    @Singleton
    fun providesAudiosData() =GetAudiosData()

}