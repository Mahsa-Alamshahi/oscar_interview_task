package com.oscar.interview_task.ui.navigation

sealed class Screen(val route: String){

    object Login: Screen(route = "login_screen")

    object SignUp: Screen(route = "sign_up_screen")


}
