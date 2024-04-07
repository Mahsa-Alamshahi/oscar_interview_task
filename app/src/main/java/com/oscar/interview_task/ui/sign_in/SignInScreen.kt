package com.oscar.interview_task.ui.sign_in

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
import com.oscar.interview_task.ui.dynamic_view.CheckViewType
import com.oscar.interview_task.ui.sign_up.SignUpState
import com.oscar.interview_task.ui.view_components.ErrorView
import com.oscar.interview_task.ui.view_components.LoadingView
import kotlin.reflect.KFunction1


@Composable
fun SignInScreenRoute(navigateToHome: () -> Unit) {

    val viewModel: SignInViewModel = hiltViewModel()

    SignInScreen(viewModel::signInUi,
        viewModel.signInUiState.value,
        viewModel::signIn,
        navigateToHome,
        viewModel.signInState.value)
}




@Composable
fun SignInScreen(getSignInFlow: () -> Unit,
                 signInUiState: SignInUiState,
                 signIn: KFunction1<HashMap<String, String>, Unit>,
                 navigateToHome: () -> Unit,
                 signInState: SignUpState
) {

    LaunchedEffect(key1 = Unit) {
        getSignInFlow()
    }


    val context = LocalContext.current


    val signInClicked = remember {
        mutableStateOf(false)
    }

    if (signInUiState.isLoading) {
        LoadingView()
    } else if (signInUiState.error.isNotEmpty()) {
        ErrorView(message = signInUiState.error)
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            signInUiState.signIn?.ui?.let {
                CheckViewType(it.nodes){map ->
                    signInClicked.value = true
                    signIn(map)

                }
            }
        }


        if (signInClicked.value){

            if (signInState.isLoading) {
                LoadingView()
            } else if (signInState.error.isNotEmpty()) {
                Toast.makeText(context, signInState.error, Toast.LENGTH_SHORT).show()
            } else {
                navigateToHome()
            }
        }

    }
}

