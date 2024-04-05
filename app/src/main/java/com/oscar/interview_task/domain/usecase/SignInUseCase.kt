package com.oscar.interview_task.domain.usecase

import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.SignInUpFlow
import com.oscar.interview_task.domain.repository.SignInRepository
import com.oscar.interview_task.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val signInRepository: SignInRepository) {

    suspend operator fun invoke(): Flow<Resource<SignInUpFlow>> = flow {

        try {

            emit(Resource.Loading())
            val signUpResponse = signInRepository.signIn()
            emit(Resource.Success(signUpResponse))

        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't get data."))
        }

    }


}