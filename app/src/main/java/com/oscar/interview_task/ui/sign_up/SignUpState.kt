package com.oscar.interview_task.ui.sign_up

import androidx.compose.runtime.Stable
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow

@Stable
data class SignUpState(
    val isLoading: Boolean = false,
    val signUp: SignInUpFlow? = null,
    val error: String = ""
)
