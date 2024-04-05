package com.oscar.interview_task.data.data_source.remote

import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {



    @Headers("Content-Type:application/json")
    @GET("/self-service/login/api")
    suspend fun login(
        @Query("refresh") refresh: Boolean = true,
        @Query("return_session_token_exchange_code") sessionToken: Boolean = true
    ): SignInUpFlow



    @Headers("Content-Type:application/json")
  @GET("/self-service/registration/api")
    suspend fun register(
        @Query("refresh") refresh: Boolean = true,
        @Query("return_session_token_exchange_code") sessionToken: Boolean = true
    ): SignInUpFlow

}