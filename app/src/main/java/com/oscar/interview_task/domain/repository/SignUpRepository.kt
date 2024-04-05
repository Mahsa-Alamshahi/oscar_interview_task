package com.oscar.interview_task.domain.repository

import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow

interface SignUpRepository {

    suspend fun signUp(): SignInUpFlow
}