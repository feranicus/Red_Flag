package mvp.redflag.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onPlaybook: () -> Unit,
    onToolkit:  () -> Unit,
    onPeople:   () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Red Flags Playbook", fontSize = 28.sp, color = MaterialTheme.colorScheme.onBackground)
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.LightGray)
            )
        }

        // Playbook card (accent gradient)
        GradientCard(
            title = "Playbook",
            subtitle = "Stories & signals by stage",
            gradient = Brush.horizontalGradient(
                listOf(Color(0xFF4F46E5), Color(0xFF14B8A6))
            ),
            textColor = Color.White,
            onClick = onPlaybook
        )

        // Toolkit card
        SolidCard(
            title = "Toolkit",
            subtitle = "Reverse image checks (free)",
            bg = MaterialTheme.colorScheme.surface,
            textColor = MaterialTheme.colorScheme.onSurface,
            onClick = onToolkit
        )

        Spacer(Modifier.weight(1f))

        // People card (bottom)
        SolidCard(
            title = "People",
            subtitle = "Notes & scores",
            bg = MaterialTheme.colorScheme.surfaceVariant,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            onClick = onPeople
        )
    }
}

@Composable
private fun GradientCard(
    title: String,
    subtitle: String,
    gradient: Brush,
    textColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(gradient)
            .clickable { onClick() }
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(title, fontSize = 22.sp, color = textColor)
            Text(subtitle, fontSize = 14.sp, color = textColor.copy(alpha = 0.9f))
        }
    }
}

@Composable
private fun SolidCard(
    title: String,
    subtitle: String,
    bg: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 8.dp,
        color = bg
    ) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(title, fontSize = 20.sp, color = textColor)
            Text(subtitle, fontSize = 14.sp, color = textColor.copy(alpha = 0.7f))
        }
    }
}
