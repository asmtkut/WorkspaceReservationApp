package com.example.workspaceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.workspaceapp.ui.login.LoginScreen
import com.example.workspaceapp.ui.main.MainScreen
import com.example.workspaceapp.ui.roomlist.RoomListScreen
import com.example.workspaceapp.ui.reservation.ReservationScreen
import com.example.workspaceapp.ui.confirmation.CompletionScreen
import com.example.workspaceapp.ui.mypage.MyPageScreen
import com.example.workspaceapp.ui.mypage.ReservationHistoryScreen
import com.example.workspaceapp.viewmodel.ReservationViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun AppNavGraph(
    navController: NavHostController,
    reservationViewModel: ReservationViewModel
) {
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
                    navController.navigate("mypage")
                },
                onHotelSelected = { hotelId ->
                    navController.navigate("room_list/$hotelId")
                }
            )
        }

        composable("mypage") {
            MyPageScreen(
                onBackClick = { navController.popBackStack() },
                onReservationHistoryClick = {
                    navController.navigate("reservation_history")
                }
                // 他のコールバックも必要に応じて渡す
            )
        }

        composable("reservation_history") {
            val reservations by reservationViewModel.reservations.collectAsState()

            ReservationHistoryScreen(
                reservations = reservations,
                onBackClick = { navController.popBackStack() }
            )
        }

        // hotelIdを受け取るように変更
        composable(
            "room_list/{hotelId}",
            arguments = listOf(navArgument("hotelId") { type = NavType.StringType })
        ) { backStackEntry ->
            val hotelId = backStackEntry.arguments?.getString("hotelId") ?: ""
            RoomListScreen(
                hotelId = hotelId,
                onRoomSelected = { roomId ->
                    navController.navigate("reservation/$hotelId/$roomId")
                }
            )
        }

        composable(
            "reservation/{hotelId}/{roomId}",
            arguments = listOf(
                navArgument("hotelId") { type = NavType.StringType },
                navArgument("roomId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val hotelId = backStackEntry.arguments?.getString("hotelId") ?: ""
            val roomId = backStackEntry.arguments?.getString("roomId") ?: ""

            ReservationScreen(
                hotelId = hotelId,
                roomId = roomId,
                reservationViewModel = reservationViewModel,
                onReserveClick = { navController.navigate("completion") }
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
