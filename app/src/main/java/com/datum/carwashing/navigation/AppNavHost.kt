package com.datum.carwashing.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.datum.carwashing.ui.SignInScreen
import com.datum.carwashing.ui.SignUpScreen
@Composable
fun AppNavHost(
){
    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "signup"
    ) {
        /* creating route "home" */
        composable(route = "signup") {
            /* Using composable function */
            SignUpScreen(navController)
        }
        composable(
            route = "login/{content}",
            arguments = listOf(
                navArgument("content") {
                    /* configuring arguments for navigation */
                    type = NavType.StringType
                }
            )
        ) {
            SignInScreen(navController, it.arguments?.getString("content"))
        }
    }
}
