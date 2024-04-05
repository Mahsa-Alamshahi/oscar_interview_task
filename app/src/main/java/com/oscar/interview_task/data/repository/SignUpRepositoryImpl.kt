package com.oscar.interview_task.data.repository

import com.oscar.interview_task.data.data_source.remote.ApiService
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow
import com.oscar.interview_task.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val apiService: ApiService): SignUpRepository {

    override suspend fun signUp(): SignInUpFlow =
      apiService.register()

}