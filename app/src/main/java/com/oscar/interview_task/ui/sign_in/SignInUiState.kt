package com.oscar.interview_task.ui.sign_in

import androidx.compose.runtime.Stable
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse

@Stable
data class SignInUiState(
    val isLoading: Boolean = false,
    val signIn: AuthenticationUiResponse? = null,
    val error: String = ""
)
