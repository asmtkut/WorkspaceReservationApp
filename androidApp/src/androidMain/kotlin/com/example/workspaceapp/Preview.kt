package com.example.workspaceapp

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.example.workspaceapp.ui.login.LoginScreen
import com.example.workspaceapp.ui.user.UserHomeScreen
import com.example.workspaceapp.viewmodel.Hotel
import com.example.workspaceapp.ui.user.ReservationScreen
import com.example.workspaceapp.ui.user.ConfirmationScreen

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLogin = { _, _ -> })
}

@Preview(showBackground = true)
@Composable
fun UserHomeScreenPreview() {
    UserHomeScreen(
        onReserve = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ReservationScreenPreview() {
    ReservationScreen(
        hotel = Hotel(
            id = 1,
            name = "ホテルA",
            address = "東京都千代田区1-1-1",
            description = "駅近で快適なワークスペースを提供するホテルです。",
            isAvailable = true
        ),
        onReserve = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmationScreenPreview() {
    ConfirmationScreen(onBackToHome = {})
}