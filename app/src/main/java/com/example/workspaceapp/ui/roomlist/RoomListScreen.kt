package com.example.workspaceapp.ui.roomlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workspaceapp.viewmodel.HotelViewModel
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RoomListScreen(
    hotelId: String,
    onRoomSelected: (roomId: String) -> Unit,
    viewModel: HotelViewModel = viewModel()
) {
    val hotels by viewModel.hotels.collectAsState()
    val selectedHotel = hotels.find { it.id == hotelId }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = selectedHotel?.name ?: "ホテルが見つかりません",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        selectedHotel?.rooms?.let { rooms ->
            LazyColumn {
                items(rooms) { room ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(room.name, style = MaterialTheme.typography.titleMedium)
                                Text("料金: ￥${room.pricePerHour}", style = MaterialTheme.typography.bodyMedium)
                                if (!room.isAvailable) {
                                    Text("満室", color = MaterialTheme.colorScheme.error)
                                }
                            }
                            if (room.isAvailable) {
                                Button(onClick = {
                                    onRoomSelected(room.id)  // ✅ roomId だけ渡す
                                }) {
                                    Text("予約")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoomListScreenPreview() {
    MaterialTheme {
        RoomListScreen(
            hotelId = "h001",
            onRoomSelected = { /* no-op */ }
        )
    }
}
