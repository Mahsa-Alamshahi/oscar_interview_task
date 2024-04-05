package com.oscar.interview_task.data.repository

import com.oscar.interview_task.data.data_source.remote.ApiService
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow
import com.oscar.interview_task.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(private val apiService: ApiService): SignInRepository {


    override suspend fun signIn(): SignInUpFlow =
       apiService.login()

}