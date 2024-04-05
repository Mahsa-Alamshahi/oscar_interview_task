package com.oscar.interview_task.ui.sign_in

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
fun SignInScreenRoute() {

    val viewModel: SignInViewModel = hiltViewModel()
    SignInScreen(viewModel::signIn,
        viewModel.signInState.value)
}




@Composable
fun SignInScreen( getSignInFlow: () -> Unit,
                  signInState: SignInState
) {

    LaunchedEffect(key1 = Unit) {
        getSignInFlow()
    }


    if (signInState.isLoading) {
        LoadingView()
    } else if (signInState.error.isNotEmpty()) {
        ErrorView(message = signInState.error)
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            signInState.signIn?.ui?.let {
                CheckViewType(it.nodes)
            }
        }

    }
}

