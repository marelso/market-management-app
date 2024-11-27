package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.marelso.marketmanagement.data.Product
import io.marelso.marketmanagement.ui.theme.Brand

@Composable
fun SalesProduct(
    modifier: Modifier = Modifier,
    product: Product,
    onAddClick: () -> Unit
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    Box(
        modifier
            .border(
                width = 1.dp,
                color = Color.Black.copy(.20f),
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp))
            .size(40.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        AppImage(url = product.pictureUrl)
    }
    Column(modifier.weight(1f)) {
        Text(
            text = product.name,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "R$ ${product.price}",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray
        )
    }
    IconButton(
        modifier = modifier.size(24.dp),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Brand,
            contentColor = Color.White
        ),
        onClick = onAddClick
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Include"
        )
    }
}