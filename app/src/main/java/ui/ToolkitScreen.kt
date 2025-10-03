package mvp.redflag.ui

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolkitScreen() {
    val ctx = LocalContext.current
    fun open(url: String) {
        CustomTabsIntent.Builder().build().launchUrl(ctx, Uri.parse(url))
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Toolkit (MVP)", fontSize = 24.sp)
        Button(onClick = { open("https://images.google.com/") }) { Text("Google Images") }
        Button(onClick = { open("https://yandex.com/images/") }) { Text("Yandex Images") }
        Button(onClick = { open("https://tineye.com/") }) { Text("TinEye") }
    }
}
