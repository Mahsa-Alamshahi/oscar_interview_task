package com.oscar.interview_task.domain.usecase

import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse
import com.oscar.interview_task.domain.repository.SignInRepository
import com.oscar.interview_task.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignInUseCase  @Inject constructor(private val signInRepository: SignInRepository) {


    suspend operator fun invoke(
        flow: String,
        requestBody: HashMap<String, String>
    ): Flow<Resource<AuthenticationResponse>> = kotlinx.coroutines.flow.flow {

        try {

            emit(Resource.Loading())
            val signUpResponse = signInRepository.signIn(flow = flow, requestBody = requestBody)
            emit(Resource.Success(signUpResponse))

        } catch (e: HttpException) {

            e.response()?.errorBody()
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            val errorMessage = e.localizedMessage ?: "Couldn't get data."
            emit(Resource.Error(errorMessage))
        }
    }
}