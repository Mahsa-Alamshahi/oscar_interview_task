package com.oscar.interview_task.ui.sign_up

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.gson.Gson
import com.oscar.interview_task.ui.dynamic_view.CheckViewType
import com.oscar.interview_task.ui.view_components.ErrorView
import com.oscar.interview_task.ui.view_components.LoadingView
import kotlin.reflect.KFunction1


@Composable
fun SignUpScreenRoute(navigateToHome: () -> Unit) {

    val viewModel: SignUpViewModel = hiltViewModel()
    SignUpScreen(
        viewModel::signUpUi,
        viewModel.signUpUiState.value,
        viewModel::signUp,
        navigateToHome,
        viewModel.signUpState.value
    )

}


@Composable
fun SignUpScreen(
    getSignUpFlow: () -> Unit,
    signUpUiState: SignUpUiState,
    signUp: KFunction1<HashMap<String, String>, Unit>,
    navigateToHome: () -> Unit,
    signUpState: SignUpState
) {


    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        getSignUpFlow()
    }

    val signUpClicked = remember {
        mutableStateOf(false)
    }


    if (signUpUiState.isLoading) {
        LoadingView()
    } else if (signUpUiState.error.isNotEmpty()) {
        ErrorView(message = signUpUiState.error)
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            signUpUiState.signUp?.ui?.let {
                CheckViewType(it.nodes){map ->
                    signUpClicked.value = true
                    signUp(map)
                }
            }
        }


        if (signUpClicked.value){

            if (signUpState.isLoading) {
                LoadingView()
            } else if (signUpState.error.isNotEmpty()) {
                Toast.makeText(context, signUpState.error, Toast.LENGTH_SHORT).show()
            } else {
                navigateToHome()
            }
        }

    }
}
