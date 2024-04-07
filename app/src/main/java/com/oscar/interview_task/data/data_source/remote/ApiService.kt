package com.oscar.interview_task.data.data_source.remote

import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {

    @Headers("Content-Type:application/json")
    @GET("/self-service/login/api")
    suspend fun loginUi(): AuthenticationUiResponse




    @Headers("Content-Type:application/json")
    @GET("/self-service/registration/api")
    suspend fun registerUi(): AuthenticationUiResponse




    @Headers("Content-Type:application/json")
    @POST("/self-service/login")
    suspend fun login(
       @Query("flow") flow: String,
       @Body requestBody: HashMap<String, String>
    ): AuthenticationResponse




    @Headers("Content-Type:application/json")
    @POST("/self-service/registration")
    suspend fun register(
        @Query("flow") flow: String,
        @Body requestBody: HashMap<String, String>
    ): AuthenticationResponse
}