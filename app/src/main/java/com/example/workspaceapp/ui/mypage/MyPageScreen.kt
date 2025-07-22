package com.example.workspaceapp.ui.mypage

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyPageScreen(
    userName: String = "山田 太郎",
    email: String = "taro.yamada@example.com",
    onLogoutClick: () -> Unit = {},
    onReservationHistoryClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "マイページ", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "ユーザー名: $userName", style = MaterialTheme.typography.titleMedium)
        Text(text = "メール: $email", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onReservationHistoryClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("予約履歴")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onLogoutClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ログアウト")
        }
        Spacer(modifier = Modifier.height(16.dp))
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
fun MyPageScreenPreview() {
    MyPageScreen()
}