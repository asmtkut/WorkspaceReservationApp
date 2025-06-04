import androidx.compose.ui.window.ComposeUIViewController
import com.example.workspaceapp.App

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }