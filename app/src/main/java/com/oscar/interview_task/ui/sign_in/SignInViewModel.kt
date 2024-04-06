package com.oscar.interview_task.ui.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.oscar.interview_task.domain.usecase.SignInUiUseCase
import com.oscar.interview_task.domain.usecase.SignInUseCase
import com.oscar.interview_task.ui.sign_up.SignUpState
import com.oscar.interview_task.ui.sign_up.SignUpUiState
import com.oscar.interview_task.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUiUseCase: SignInUiUseCase,
    private val signInUseCase: SignInUseCase
): ViewModel(){



    private val _signInUiState = mutableStateOf(SignInUiState())
    var signInUiState: State<SignInUiState> = _signInUiState


    private val _signInState = mutableStateOf(SignUpState())
    var signInState: State<SignUpState> = _signInState


    private val flow= mutableStateOf("")

    fun signInUi() {
        viewModelScope.launch {
            val signUpResponse = signInUiUseCase()
            signUpResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signInUiState.value = SignInUiState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _signInUiState.value = SignInUiState(signIn = response.data)
                    }

                    is Resource.Error -> {
                        _signInUiState.value =
                            SignInUiState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }
    }



    fun signIn(requestBodyHashMap: HashMap<String, String>){
        viewModelScope.launch {
            val signInUiResponse = signInUiUseCase()
            signInUiResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signInState.value = SignUpState(isLoading = true)
                    }

                    is Resource.Success -> {
                        flow.value = SignUpUiState(signUp = response.data).signUp?.id ?: ""
                        getSignInResponse(requestBodyHashMap)
                    }

                    is Resource.Error -> {
                        _signInState.value =
                            SignUpState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }

    }




    private fun getSignInResponse(requestBodyHashMap: HashMap<String, String>) {
        viewModelScope.launch {
            val signUpResponse = signInUseCase(flow = flow.value, requestBody = requestBodyHashMap)
            signUpResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signInState.value = SignUpState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _signInState.value = SignUpState(signUp = response.data)

                    }

                    is Resource.Error -> {
                        _signInState.value =
                            SignUpState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }
    }
}
