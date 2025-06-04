package com.example.workspaceapp.ui.user

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workspaceapp.viewmodel.Hotel

@Composable
fun ReservationScreen(
    hotel: Hotel,
    onReserve: (Hotel) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("予約確認") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = hotel.name, style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = hotel.address, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = hotel.description, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = if (hotel.isAvailable) "空きあり" else "満室",
                color = if (hotel.isAvailable) MaterialTheme.colors.primary else MaterialTheme.colors.error
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { onReserve(hotel) },
                enabled = hotel.isAvailable,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("このホテルを予約する")
            }
        }
    }
}