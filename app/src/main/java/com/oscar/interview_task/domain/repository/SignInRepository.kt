package com.oscar.interview_task.domain.repository

import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse
import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse


interface SignInRepository {

    suspend fun signInUi(): AuthenticationUiResponse
    suspend fun signIn(flow: String, requestBody: HashMap<String, String>): AuthenticationResponse
}