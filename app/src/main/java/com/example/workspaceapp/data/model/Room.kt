package com.example.workspaceapp.data.model

data class Room(
    val id: String,
    val hotelId: String, // 所属ホテルID
    val name: String,
    val capacity: Int,
    val pricePerHour: Int,
    val isAvailable: Boolean
)