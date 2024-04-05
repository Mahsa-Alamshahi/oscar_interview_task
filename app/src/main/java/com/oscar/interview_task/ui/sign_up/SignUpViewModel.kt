package com.oscar.interview_task.ui.sign_up

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.oscar.interview_task.domain.usecase.SignUpUseCase
import com.oscar.interview_task.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {


    private val _signUpState = mutableStateOf(SignUpState())
    var signUpState: State<SignUpState> = _signUpState



    fun signUp() {
        viewModelScope.launch {
            val signUpResponse = signUpUseCase()
            signUpResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signUpState.value = SignUpState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _signUpState.value = SignUpState(signUp = response.data)
                        Logger.d(_signUpState.value)
                    }

                    is Resource.Error -> {
                        _signUpState.value =
                            SignUpState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }
    }
}