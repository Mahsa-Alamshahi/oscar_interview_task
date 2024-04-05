package com.oscar.interview_task.ui.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.interview_task.domain.usecase.SignInUseCase
import com.oscar.interview_task.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
): ViewModel(){



    private val _signInState = mutableStateOf(SignInState())
    var signInState: State<SignInState> = _signInState



    fun signIn() {
        viewModelScope.launch {
            val signUpResponse = signInUseCase()
            signUpResponse.collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        _signInState.value = SignInState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _signInState.value = SignInState(signIn = response.data)
                    }

                    is Resource.Error -> {
                        _signInState.value =
                            SignInState(error = response.message ?: "An unexpected error occured.")
                    }

                }

            }
        }
    }


}