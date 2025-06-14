import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.example.workspaceapp.App
import com.example.workspaceapp.getPlatformName

actual fun getPlatformName(): String = "Desktop"

@Composable
fun MainView() = App()

@Preview
@Composable
fun AppPreview() {
    App()
}