package com.example.workspaceapp.ui.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ReservationScreen(
    roomName: String,
    price: Int,
    onReserveClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "予約内容", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "部屋: $roomName", style = MaterialTheme.typography.titleMedium)
        Text(text = "料金: ￥$price", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { onReserveClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("予約する")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReservationScreenPreview() {
    MaterialTheme {
        ReservationScreen(
            roomName = "シングルルーム",
            price = 8000,
            onReserveClick = {}
        )
    }
}