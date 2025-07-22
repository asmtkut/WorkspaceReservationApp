package com.example.workspaceapp.data.model

data class Reservation(
    val reservationId: String,
    val hotelName: String,
    val roomName: String,
    val price: Int,
    val timestamp: Long
)