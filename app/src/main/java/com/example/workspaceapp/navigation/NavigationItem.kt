package com.example.workspaceapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route: String, val label: String, val icon: ImageVector) {
    object RoomList : NavigationItem("room_list", "Rooms", Icons.Filled.Home)
    object MyPage : NavigationItem("mypage", "My Page", Icons.Filled.Person)
}