package com.oscar.interview_task.ui.sign_up

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.interview_task.domain.usecase.SignUpUiUseCase
import com.oscar.interview_task.domain.usecase.SignUpUseCase
import com.oscar.interview_task.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUiUseCase: SignUpUiUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {


    private val _signUpUiState = mutableStateOf(SignUpUiState())
    var signUpUiState: State<SignUpUiState> = _signUpUiState


     private val _signUpState = mutableStateOf(SignUpState())
    var signUpState: State<SignUpState> = _signUpState


    private val flow= mutableStateOf("")


    fun signUpUi() {
        viewModelScope.launch {
            val signUpResponse = signUpUiUseCase()
            signUpResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signUpUiState.value = SignUpUiState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _signUpUiState.value = SignUpUiState(signUp = response.data)
                    }

                    is Resource.Error -> {
                        _signUpUiState.value =
                            SignUpUiState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }
    }



    fun signUp(requestBodyHashMap: HashMap<String, String>){
        viewModelScope.launch {
            val signUpUiResponse = signUpUiUseCase()
            signUpUiResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signUpState.value = SignUpState(isLoading = true)
                    }

                    is Resource.Success -> {
                        flow.value = SignUpUiState(signUp = response.data).signUp?.id ?: ""
                       getSignUpResponse(requestBodyHashMap)
                    }

                    is Resource.Error -> {
                        _signUpState.value =
                            SignUpState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }

    }




    private fun getSignUpResponse(requestBodyHashMap: HashMap<String, String>) {
        viewModelScope.launch {
            val signUpResponse = signUpUseCase(flow = flow.value, requestBody = requestBodyHashMap)
            signUpResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signUpState.value = SignUpState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _signUpState.value = SignUpState(signUp = response.data)
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