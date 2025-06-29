package com.example.workspaceapp.data.repository

import com.example.workspaceapp.data.model.Hotel
import com.example.workspaceapp.data.model.Room

class FakeHotelRepository : HotelRepository {

    private val fakeHotels = listOf(
        Hotel(
            id = "h001",
            name = "渋谷ホテル",
            address = "東京都渋谷区○○",
            imageUrl = "https://example.com/shibuya.jpg",
            rooms = listOf(
                Room("r001", "h001", "シングルA", 1, 1000, true),
                Room("r002", "h001", "ツインB", 2, 2000, false)
            )
        ),
        Hotel(
            id = "h002",
            name = "新宿ホテル",
            address = "東京都新宿区××",
            imageUrl = "https://example.com/shinjuku.jpg",
            rooms = listOf(
                Room("r003", "h002", "ダブルC", 2, 2500, true),
                Room("r004", "h002", "スイートD", 3, 5000, true)
            )
        )
    )

    override suspend fun getHotels(): List<Hotel> {
        // 実際のアプリではAPIやDBアクセスになる部分
        return fakeHotels
    }

    override suspend fun getHotelById(id: String): Hotel? {
        return fakeHotels.find { it.id == id }
    }
}
