package com.oscar.interview_task.data.repository

import com.orhanobut.logger.Logger
import com.oscar.interview_task.data.data_source.remote.ApiService
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse
import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse
import com.oscar.interview_task.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SignUpRepository {

    override suspend fun signUpUi(): AuthenticationUiResponse =
        apiService.registerUi()

    override suspend fun signUp(flow: String, requestBody: HashMap<String, String>): AuthenticationResponse {
        var response = apiService.register(flow = flow, requestBody = requestBody)
        Logger.d("Res : $response")
        return response
    }

}