package com.oscar.interview_task.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscar.interview_task.ui.home.HomeScreenRoute
import com.oscar.interview_task.ui.main.MainScreenRoute
import com.oscar.interview_task.ui.sign_in.SignInScreenRoute
import com.oscar.interview_task.ui.sign_up.SignUpScreenRoute

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Main.route) {
        signInRoute(navController)
        signUpRoute(navController)
        mainRoute(navController)
        homeRoute()
    }
}


fun NavGraphBuilder.signInRoute(navController: NavController) {
    composable(
        route = Screen.SignIn.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        },
    ) {

        SignInScreenRoute(){
            navController.navigate(Screen.Home.route)
        }
    }
}


fun NavGraphBuilder.signUpRoute(navController: NavController) {
    composable(
        route = Screen.SignUp.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
    ) {


        SignUpScreenRoute() {
            navController.navigate(Screen.Home.route)

        }
    }
}


fun NavGraphBuilder.mainRoute(navController: NavController) {
    composable(
        route = Screen.Main.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        },
    ) {


        MainScreenRoute(onSignUpNavigation = {
            navController.navigate(Screen.SignUp.route)
        }) {
            navController.navigate(Screen.SignIn.route)
        }
    }
}

fun NavGraphBuilder.homeRoute() {
    composable(
        route = Screen.Home.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        },
    ) {
        HomeScreenRoute()
    }
}