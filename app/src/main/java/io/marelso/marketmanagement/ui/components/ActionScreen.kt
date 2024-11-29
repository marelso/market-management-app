package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ActionScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    icon: ImageVector,
    title: String? = null,
    description: String,
    onActionClick: () -> Unit
) = Box(
    modifier = modifier
        .fillMaxSize()
        .padding(
            top = padding.calculateTopPadding() + 24.dp,
            bottom = padding.calculateBottomPadding() + 24.dp,
            start = 24.dp,
            end = 24.dp
        ),
    contentAlignment = Alignment.Center
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = modifier.size(80.dp),
            imageVector = icon,
            contentDescription = "Icon",
            tint = Color.Red
        )

        title?.let {
            Text(
                text = description,
                style = MaterialTheme.typography.titleMedium.copy(
                    textAlign = TextAlign.Center
                )
            )
        }

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(
                textAlign = TextAlign.Center
            )
        )

        OutlinedButton(
            shape = RoundedCornerShape(4.dp),
            onClick = onActionClick
        ) {
            Text(
                text = "Adicionar produto",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}