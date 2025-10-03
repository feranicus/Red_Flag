package mvp.redflag.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun StageScreen() {
    val stages = listOf("First Date", "Second Date", "Month 1")
    var selected by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Choose Stage", style = MaterialTheme.typography.headlineSmall)

        // Pills (chips) to pick a stage
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(stages) { index, label ->
                FilterChip(
                    selected = selected == index,
                    onClick = { selected = index },
                    label = { Text(label) }
                )
            }
        }

        // Placeholder area for the selected stage's cards
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(20.dp),
            tonalElevation = 2.dp,
            shadowElevation = 6.dp
        ) {
            Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "Coming next:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "STAR story cards for \"${stages[selected]}\"",
                    fontSize = 16.sp
                )
                Text(
                    text = "In MVP this is a placeholder. Next step: load cards from JSON.",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
