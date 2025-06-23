package com.example.workspaceapp.ui.confirmation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CompletionScreen(
    onHomeClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "予約が完了しました！",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = onHomeClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ホームへ戻る")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompletionScreenPreview() {
    MaterialTheme {
        CompletionScreen()
    }
}