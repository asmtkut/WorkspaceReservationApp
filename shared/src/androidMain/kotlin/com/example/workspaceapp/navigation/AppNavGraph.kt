package com.example.workspaceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workspaceapp.ui.login.LoginScreen
import com.example.workspaceapp.ui.user.UserHomeScreen
import com.example.workspaceapp.ui.user.ReservationScreen
import com.example.workspaceapp.ui.user.ConfirmationScreen
import com.example.workspaceapp.viewmodel.Hotel

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object UserHome : Screen("user_home")
    object Reservation : Screen("reservation")
    object Confirmation : Screen("confirmation")
}

@Composable
actual fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLogin = { _, _ ->
                    navController.navigate(Screen.UserHome.route)
                }
            )
        }
        composable(Screen.UserHome.route) {
            UserHomeScreen(
                onReserve = { _ ->
                    navController.navigate(Screen.Reservation.route)
                }
            )
        }
        composable(Screen.Reservation.route) {
            val sampleHotel = Hotel(
                id = 1,
                name = "ホテルA",
                address = "東京都千代田区1-1-1",
                description = "駅近で快適なワークスペースを提供するホテルです。",
                isAvailable = true
            )
            ReservationScreen(
                hotel = sampleHotel,
                onReserve = {
                    navController.navigate(Screen.Confirmation.route)
                }
            )
        }
        composable(Screen.Confirmation.route) {
            ConfirmationScreen(
                onBackToHome = {
                    navController.navigate(Screen.UserHome.route) {
                        popUpTo(Screen.Login.route) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}