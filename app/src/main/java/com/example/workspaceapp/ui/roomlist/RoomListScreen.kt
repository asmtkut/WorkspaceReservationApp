package com.example.workspaceapp.ui.roomlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Room(val id: Int, val name: String, val price: Int, val isAvailable: Boolean)

@Composable
fun RoomListScreen(
    onRoomSelected: (roomName: String, price: Int) -> Unit
) {
    val rooms = listOf(
        Room(1, "シングルルーム", 8000, true),
        Room(2, "ダブルルーム", 12000, true),
        Room(3, "スイートルーム", 25000, false)
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("空き部屋一覧", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
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
                            Text("料金: ￥${room.price}", style = MaterialTheme.typography.bodyMedium)
                            if (!room.isAvailable) {
                                Text("満室", color = MaterialTheme.colorScheme.error)
                            }
                        }
                        if (room.isAvailable) {
                            Button(onClick = {
                                onRoomSelected(room.name, room.price)
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

@Preview(showBackground = true)
@Composable
fun RoomListScreenPreview() {
    MaterialTheme {
        RoomListScreen(onRoomSelected = { _, _ -> })
    }
}