package com.oscar.interview_task.domain.usecase

import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.AuthenticationUiResponse
import com.oscar.interview_task.domain.repository.SignUpRepository
import com.oscar.interview_task.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class SignUpUiUseCase @Inject constructor(private val signUpRepository: SignUpRepository) {

    suspend operator fun invoke(): Flow<Resource<AuthenticationUiResponse>> = flow {

        try {

            emit(Resource.Loading())
            val signUpResponse = signUpRepository.signUpUi()
            emit(Resource.Success(signUpResponse))

        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't get data."))
        }

    }
}