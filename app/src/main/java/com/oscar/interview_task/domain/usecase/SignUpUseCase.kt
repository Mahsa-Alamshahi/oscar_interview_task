package com.oscar.interview_task.domain.usecase

import com.orhanobut.logger.Logger
import com.oscar.interview_task.data.data_source.remote.dto.authentication_response.AuthenticationResponse
import com.oscar.interview_task.domain.repository.SignUpRepository
import com.oscar.interview_task.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val signUpRepository: SignUpRepository) {


    suspend operator fun invoke(
        flow: String,
        requestBody: HashMap<String, String>
    ): Flow<Resource<AuthenticationResponse>> = flow {

        try {

            emit(Resource.Loading())
            val signUpResponse = signUpRepository.signUp(flow = flow, requestBody = requestBody)
            Logger.d("Res : $signUpResponse")
            emit(Resource.Success(signUpResponse))

        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't get data."))
        }
    }
}