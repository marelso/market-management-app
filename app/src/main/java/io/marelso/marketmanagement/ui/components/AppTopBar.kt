package io.marelso.marketmanagement.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

data class TopBarAction(
    val icon: Int,
    val isActive: Boolean,
    val onActionClick: () -> Unit
)

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navIcon: ImageVector = Icons.Default.ArrowBack,
    actions: List<TopBarAction> = listOf(),
    onNavigationClick: () -> Unit
) = TopAppBar(
    title = {
        title?.let {
            Text(text = it, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
        }
    },
    navigationIcon = {
        IconButton(onClick = onNavigationClick) {
            Icon(
                imageVector = navIcon,
                contentDescription = ""
            )
        }
    },
    actions = {
        actions.forEach {
            IconButton(onClick = it.onActionClick) {
                Icon(
                    imageVector = ImageVector.vectorResource(it.icon),
                    contentDescription = ""
                )
            }
        }
    },
    backgroundColor = MaterialTheme.colors.background
)