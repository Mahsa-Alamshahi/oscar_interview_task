package com.oscar.interview_task.ui.sign_in

import androidx.compose.runtime.Stable
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow

@Stable
data class SignInState(
    val isLoading: Boolean = false,
    val signIn: SignInUpFlow? = null,
    val error: String = ""
)
