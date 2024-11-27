package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import io.marelso.marketmanagement.ui.store.navigation.StoreRoutes
import io.marelso.marketmanagement.ui.theme.Brand
import java.util.Locale

@Composable
fun StoreBottomNav(
    modifier: Modifier = Modifier,
    options: List<StoreRoutes>,
    selected: StoreRoutes,
    onItemClick: (StoreRoutes) -> Unit,
    onActionClick: (Boolean) -> Unit
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        options.forEachIndexed { id, route ->
            if(id == 2) {
                Box(modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    IconButton(
                        modifier = modifier
                            .background(Brand, RoundedCornerShape(4.dp))
                            .height(32.dp)
                            .width(48.dp),
                        onClick = { onActionClick(true) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = MaterialTheme.colors.background
                        )
                    }
                }
            }
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = modifier.size(24.dp),
                        imageVector = ImageVector.vectorResource(route.icon),
                        contentDescription = "",
                        tint = if(selected == route) {
                            LocalContentColor.current
                        } else {
                            Color.Black.copy(alpha = .25f)
                        }
                    )
                },
                label = {
                    Text(
                        route.route.substringAfter("/")
                            .replaceFirstChar { it.titlecase(Locale.getDefault()) },
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                    )
                },
                selected = selected == route,
                alwaysShowLabel = false,
                onClick = {
                    if (selected != route) {
                        onItemClick(route)
                    }
                }
            )
        }
    }
}