package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.marelso.marketmanagement.data.Store

@Composable
fun StoreCard(
    modifier: Modifier = Modifier,
    store: Store,
    onStoreClick: () -> Unit
) {
    Box(
        modifier
            .clickable { onStoreClick() }
            .border(
                width = 1.dp,
                color = Color.Black.copy(alpha = .20f),
                shape = RoundedCornerShape(4.dp)
            )
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = store.name,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        )
    }
}