package com.oscar.interview_task.di

import com.oscar.interview_task.data.data_source.remote.ApiService
import com.oscar.interview_task.data.repository.SignInRepositoryImpl
import com.oscar.interview_task.data.repository.SignUpRepositoryImpl
import com.oscar.interview_task.domain.repository.SignInRepository
import com.oscar.interview_task.domain.repository.SignUpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideSignUpRepository(apiService: ApiService): SignUpRepository =
        SignUpRepositoryImpl(apiService = apiService)


    @Provides
    @Singleton
    fun provideSignInRepository(apiService: ApiService): SignInRepository =
        SignInRepositoryImpl(apiService)
}