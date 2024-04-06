package com.oscar.interview_task.ui.sign_up

import androidx.compose.runtime.Stable
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse

@Stable
data class SignUpUiState(
    val isLoading: Boolean = false,
    val signUp: AuthenticationUiResponse? = null,
    val error: String = ""
)
