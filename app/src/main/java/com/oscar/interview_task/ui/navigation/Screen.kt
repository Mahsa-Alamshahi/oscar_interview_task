package com.oscar.interview_task.ui.navigation

sealed class Screen(val route: String){

    object Main: Screen(route = "main_screen")
    object SignUp: Screen(route = "sign_up_screen")
    object SignIn: Screen(route = "sign_in_screen")
    object Home: Screen(route = "home_screen")

}
