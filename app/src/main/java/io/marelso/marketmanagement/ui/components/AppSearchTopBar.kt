package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppSearchTopBar(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    query: String,
    onQueryChange: (String) -> Unit
) = Column(modifier.background(MaterialTheme.colorScheme.background)) {
    AppSearchBar(
        modifier = modifier.padding(12.dp),
        query = query,
        placeholder = "Procure por nome",
        onSearch = onQueryChange,
        onClearClicked = { onQueryChange("") }
    )
    if(isLoading) {
        LinearProgressIndicator(modifier.fillMaxWidth())
    } else {
        Divider()
    }
}