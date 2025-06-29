package com.example.workspaceapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//data class Room(
//    val id: Int,
//    val name: String,
//    val price: Int,
//    val isAvailable: Boolean
//)
//
//class RoomListViewModel : ViewModel() {
//    private val _rooms = MutableStateFlow(
//        listOf(
//            Room(1, "シングルルーム", 8000, true),
//            Room(2, "ダブルルーム", 12000, true),
//            Room(3, "スイートルーム", 25000, false)
//        )
//    )
//    val rooms: StateFlow<List<Room>> = _rooms
//}