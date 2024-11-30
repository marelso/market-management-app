package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.marelso.marketmanagement.data.Product

@Composable
fun ProductStockCard(modifier: Modifier = Modifier, product: Product) = Box(
    modifier = modifier
        .border(
            1.dp,
            color = Color.Black.copy(.20f),
            shape = RoundedCornerShape(4.dp)
        )
        .padding(12.dp)
) {
    Row(
        modifier
            .align(Alignment.Center)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier.size(36.dp)) {
            AppImage(url = product.pictureUrl)
        }
        Column(modifier.weight(1f, false)) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = product.name
            )
            Text(
                modifier = modifier.fillMaxWidth(),
                text = "${product.count} unidades"
            )
        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.ArrowForward,
                ""
            )
        }
    }
}