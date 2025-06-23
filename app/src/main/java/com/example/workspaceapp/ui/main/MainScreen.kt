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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Hotel(val id: Int, val name: String, val x: Int, val y: Int)

@Composable
fun MainScreen(
    onMyPageClick: () -> Unit = {},
    onHotelSelected: () -> Unit = {}
) {
    val hotels = listOf(
        Hotel(1, "ホテルA", 1, 2),
        Hotel(2, "ホテルB", 3, 1),
        Hotel(3, "ホテルC", 2, 3)
    )

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
                        Text(
                            text = hotel.name,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Button(
                            onClick = {
                                onHotelSelected()
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
    MaterialTheme {
        MainScreen()
    }
}