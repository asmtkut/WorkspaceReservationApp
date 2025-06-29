package com.example.workspaceapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workspaceapp.viewmodel.HotelViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    onMyPageClick: () -> Unit = {},
    onHotelSelected: (hotelId: String) -> Unit = {},
    viewModel: HotelViewModel = viewModel()
) {
    val hotels by viewModel.hotels.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        // 左上にマイページボタン
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(48.dp)
                .background(
                    color = Color(0xFFFF9800),
                    shape = CircleShape
                )
        ) {
            IconButton(
                onClick = onMyPageClick,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "マイページ",
                    tint = Color.White
                )
            }
        }

        // ホテルリスト
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(hotels) { hotel ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = hotel.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = hotel.address,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        Button(
                            onClick = {
                                onHotelSelected(hotel.id)
                            }
                        ) {
                            Text("詳細")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        onMyPageClick = {},
        onHotelSelected = {}
    )
}
