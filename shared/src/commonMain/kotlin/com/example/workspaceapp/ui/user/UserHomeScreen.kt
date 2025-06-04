package com.example.workspaceapp.ui.user

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Hotel(
    val id: Int,
    val name: String,
    val address: String,
    val isAvailable: Boolean
)

@Composable
fun UserHomeScreen(
    hotels: List<Hotel> = listOf(
        Hotel(1, "ホテルA", "東京都千代田区1-1-1", true),
        Hotel(2, "ホテルB", "大阪府大阪市2-2-2", false),
        Hotel(3, "ホテルC", "北海道札幌市3-3-3", true)
    ),
    onReserve: (Hotel) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("ホテル一覧") })
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(hotels) { hotel ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = hotel.name, style = MaterialTheme.typography.h6)
                            Text(text = hotel.address, style = MaterialTheme.typography.body2)
                            Text(
                                text = if (hotel.isAvailable) "空きあり" else "満室",
                                color = if (hotel.isAvailable) MaterialTheme.colors.primary else MaterialTheme.colors.error
                            )
                        }
                        Button(
                            onClick = { onReserve(hotel) },
                            enabled = hotel.isAvailable
                        ) {
                            Text("予約")
                        }
                    }
                }
            }
        }
    }
}