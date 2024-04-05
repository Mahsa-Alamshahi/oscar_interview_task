package com.oscar.interview_task.ui.sign_up

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscar.interview_task.ui.view_components.ErrorView
import com.oscar.interview_task.ui.view_components.LoadingView
import com.oscar.interview_task.ui.dynamic_view.CheckViewType


@Composable
fun SignUpScreenRoute() {

    val viewModel: SignUpViewModel = hiltViewModel()
    SignUpScreen(
        viewModel::signUp,
        viewModel.signUpState.value
    )

}


@Composable
fun SignUpScreen(
    getSignUpFlow: () -> Unit,
    signUpState: SignUpState
) {


    LaunchedEffect(key1 = Unit) {
        getSignUpFlow()
    }


    if (signUpState.isLoading) {
        LoadingView()
    } else if (signUpState.error.isNotEmpty()) {
        ErrorView(message = signUpState.error)
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            signUpState.signUp?.ui?.let {
                CheckViewType(it.nodes)
            }
        }

    }
}
