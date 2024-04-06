package com.oscar.interview_task.data.repository

import com.oscar.interview_task.data.data_source.remote.ApiService
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse
import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse
import com.oscar.interview_task.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SignInRepository {



    override suspend fun signInUi(): AuthenticationUiResponse =
        apiService.loginUi()



    override suspend fun signIn(
        flow: String,
        requestBody: HashMap<String, String>
    ): AuthenticationResponse = apiService.login(
        flow = flow,
        requestBody = requestBody
    )


}