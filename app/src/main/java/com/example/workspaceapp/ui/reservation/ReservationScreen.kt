package com.example.workspaceapp.ui.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.workspaceapp.viewmodel.HotelViewModel
import com.example.workspaceapp.viewmodel.ReservationViewModel
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ReservationScreen(
    hotelId: String,
    roomId: String,
    onReserveClick: () -> Unit,
    hotelViewModel: HotelViewModel = hiltViewModel(),
    reservationViewModel: ReservationViewModel = hiltViewModel()
) {
    val hotels = hotelViewModel.hotels.collectAsState().value
    val hotel = hotels.find { it.id == hotelId }
    val room = hotel?.rooms?.find { it.id == roomId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "予約画面",
            style = MaterialTheme.typography.headlineMedium
        )

        if (hotel == null || room == null) {
            Text("選択されたホテルまたは部屋が見つかりません")
        } else {
            Text("ホテル名: ${hotel.name}")
            Text("部屋名: ${room.name}")
            Text("料金: ￥${room.pricePerHour}")

            Button(
                onClick = {
                    try {
                        reservationViewModel.addReservation(
                            hotelName = hotel.name,
                            roomName = room.name,
                            price = room.pricePerHour
                        )
                        onReserveClick()
                    } catch (e: Exception) {
                        e.printStackTrace()
                        // 必要ならログやSnackbarで通知
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("予約する")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReservationScreenPreview() {
    MaterialTheme {
        ReservationScreen(
            hotelId = "dummy_hotel_id",
            roomId = "dummy_room_id",
            onReserveClick = {}
        )
    }
}
