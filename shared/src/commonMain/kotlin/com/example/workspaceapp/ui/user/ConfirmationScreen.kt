package com.example.workspaceapp.ui.user

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmationScreen(
    onBackToHome: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("予約完了") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ご予約が完了しました！",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onBackToHome,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ホームに戻る")
            }
        }
    }
}