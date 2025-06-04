package com.example.workspaceapp

import androidx.compose.runtime.Composable
//import com.example.workspaceapp.App

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()
