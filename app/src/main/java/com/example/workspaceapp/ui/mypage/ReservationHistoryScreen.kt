package com.example.workspaceapp.ui.mypage

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workspaceapp.viewmodel.ReservationViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.workspaceapp.data.model.Reservation
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ReservationHistoryScreen(
    reservations: List<Reservation>,
    onBackClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("予約履歴", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        if (reservations.isEmpty()) {
            Text("予約履歴はありません")
        } else {
            reservations.forEach { res ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("ホテル名: ${res.hotelName}")
                        Text("部屋名: ${res.roomName}")
                        Text("料金: ￥${res.price}")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("戻る")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReservationHistoryScreenPreview() {
    ReservationHistoryScreen(
        reservations = listOf(
            Reservation(
                reservationId = "1",
                hotelName = "ホテルA",
                roomName = "シングル",
                price = 8000,
                timestamp = 1720000000000L
            ),
            Reservation(
                reservationId = "2",
                hotelName = "ホテルB",
                roomName = "ダブル",
                price = 12000,
                timestamp = 1725000000000L
            )
        ),
        onBackClick = {}
    )
}