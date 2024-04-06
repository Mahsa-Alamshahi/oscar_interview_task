package com.oscar.interview_task.domain.repository

import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse
import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse

interface SignUpRepository {

    suspend fun signUpUi(): AuthenticationUiResponse
    suspend fun signUp(flow: String, requestBody: HashMap<String, String>): AuthenticationResponse
}