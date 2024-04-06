package com.oscar.interview_task.ui.sign_in

import androidx.compose.runtime.Stable
import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse

@Stable
data class SignInState(
    val isLoading: Boolean = false,
    val signUp: AuthenticationResponse? = null,
    val error: String = ""
)
