package io.marelso.marketmanagement.ui.store.stock

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import io.marelso.marketmanagement.data.Product
import io.marelso.marketmanagement.ui.components.AppImage
import io.marelso.marketmanagement.ui.components.AppSearchBar

@Composable
fun StoreStockScreenHoisting(viewModel: StoreStockViewModel) {
    val products = viewModel.products.collectAsLazyPagingItems()
    val query by viewModel.query.collectAsStateWithLifecycle()

    StoreStockScreen(
        holder = StoreStockScreenHolder(
            products = products,
            query = query,
            onQueryChange = viewModel::onQueryChanged
        )
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun StoreStockScreen(
    modifier: Modifier = Modifier,
    holder: StoreStockScreenHolder
) {
    Scaffold(
        topBar = {
            Column(modifier.background(MaterialTheme.colorScheme.background)) {
                AppSearchBar(
                    modifier = modifier.padding(12.dp),
                    query = holder.query,
                    onSearch = holder.onQueryChange,
                    placeholder = "Procure por nome",
                    onClearClicked = {
                        holder.onQueryChange("")
                    }
                )
                Divider()
            }
        }
    ){ padding ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding() + 12.dp,
                bottom = padding.calculateBottomPadding() + 12.dp,
                start = 12.dp,
                end = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(holder.products.itemCount, key = { holder.products[it]?.id.orEmpty() }) { index ->
                holder.products[index]?.let { ProductStockCard(product = it) }
            }
        }
    }
}

data class StoreStockScreenHolder(
    val products: LazyPagingItems<Product>,
    val query: String,
    val onQueryChange: (String) -> Unit
)

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