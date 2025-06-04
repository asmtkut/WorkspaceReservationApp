package com.example.workspaceapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.workspaceapp.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

actual fun getPlatformName(): String = "Desktop"