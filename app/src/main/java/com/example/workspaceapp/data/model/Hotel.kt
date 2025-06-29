package com.example.workspaceapp.data.model

data class Hotel(
    val id: String,
    val name: String,
    val address: String,
    val imageUrl: String,
    val rooms: List<Room>
)