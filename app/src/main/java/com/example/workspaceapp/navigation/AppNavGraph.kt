package com.example.workspaceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.workspaceapp.ui.login.LoginScreen
import com.example.workspaceapp.ui.main.MainScreen
import com.example.workspaceapp.ui.roomlist.RoomListScreen
import com.example.workspaceapp.ui.reservation.ReservationScreen
import com.example.workspaceapp.ui.confirmation.CompletionScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("main")
                }
            )
        }
        composable("main") {
            MainScreen(
                onMyPageClick = {
                    navController.navigate("room_list")
                },
                onHotelSelected = {
                    navController.navigate("room_list")
                }
            )
        }
        composable("room_list") {
            RoomListScreen(
                onRoomSelected = { roomName, price ->
                    navController.navigate("reservation/$roomName/$price")
                }
            )
        }
        composable("reservation/{roomName}/{price}") { backStackEntry ->
            val roomName = backStackEntry.arguments?.getString("roomName") ?: ""
            val price = backStackEntry.arguments?.getString("price")?.toIntOrNull() ?: 0
            ReservationScreen(
                roomName = roomName,
                price = price,
                onReserveClick = {
                    navController.navigate("completion")
                }
            )
        }
        composable("completion") {
            CompletionScreen(
                onHomeClick = {
                    navController.navigate("main") {
                        popUpTo("main") { inclusive = true }
                    }
                }
            )
        }
    }
}