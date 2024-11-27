package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SalesBottomBar(modifier: Modifier = Modifier) = Row(
    modifier
        .border(1.dp, Color.Black.copy(alpha = .20f))
        .fillMaxWidth()
        .padding(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Column(modifier.weight(1f)) {
        Text(
            text = "Sem produtos na cesta",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "R$ 0,00", style = MaterialTheme.typography.titleSmall, color = Color.Gray)
    }
    Button(onClick = {  }, shape = RoundedCornerShape(4.dp)) {
        Text(text = "Comprar", style = MaterialTheme.typography.labelLarge)
    }
}