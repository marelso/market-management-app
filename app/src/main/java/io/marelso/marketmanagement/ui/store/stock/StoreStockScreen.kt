package io.marelso.marketmanagement.ui.store.stock

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import io.marelso.marketmanagement.R
import io.marelso.marketmanagement.data.Product
import io.marelso.marketmanagement.ui.components.AppImage
import io.marelso.marketmanagement.ui.components.AppSearchTopBar
import io.marelso.marketmanagement.ui.components.shimmerLoadingAnimation

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

@Composable
private fun StoreStockScreen(
    modifier: Modifier = Modifier,
    holder: StoreStockScreenHolder
) {
    Scaffold(
        topBar = {
            AppSearchTopBar(
                isLoading = holder.products.loadState.refresh is LoadState.Loading,
                query = holder.query,
                onQueryChange = holder.onQueryChange
            )
        }
    ) { padding ->
        when (holder.products.loadState.refresh) {
            is LoadState.Error -> {
                Box(
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
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Icon",
                            tint = Color.Red
                        )

                        Text(
                            text = "Reload this page and try again. If this error persists, contact support.",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                textAlign = TextAlign.Center
                            )
                        )

                        OutlinedButton(
                            shape = RoundedCornerShape(4.dp),
                            onClick = { holder.products.retry() }
                        ) {
                            Text(
                                text = "Adicionar produto",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }

            is LoadState.Loading -> {
                Column(
                    modifier = modifier.padding(
                        PaddingValues(
                            top = padding.calculateTopPadding() + 12.dp,
                            bottom = padding.calculateBottomPadding() + 12.dp,
                            start = 12.dp,
                            end = 12.dp
                        )
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    List(5) {
                        Box(
                            modifier = modifier
                                .height(68        .dp)
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    color = Color.Black.copy(.20f),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .shimmerLoadingAnimation()
                        )
                    }
                }
            }

            is LoadState.NotLoading -> {
                if (holder.products.itemCount != 0) {
                    LazyColumn(
                        contentPadding = PaddingValues(
                            top = padding.calculateTopPadding() + 12.dp,
                            bottom = padding.calculateBottomPadding() + 12.dp,
                            start = 12.dp,
                            end = 12.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            holder.products.itemCount,
                            key = { holder.products[it]?.id.orEmpty() }) { index ->
                            holder.products[index]?.let { ProductStockCard(product = it) }
                        }
                    }
                } else {
                    Box(
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
                                imageVector = ImageVector.vectorResource(R.drawable.ic_no_image),
                                contentDescription = "Icon",
                                tint = Color.Unspecified
                            )

                            Text(
                                text = "Não há nenhum produto com esse nome. Utilize o botão abaixo para registrá-lo.",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    textAlign = TextAlign.Center
                                )
                            )

                            OutlinedButton(
                                shape = RoundedCornerShape(4.dp),
                                onClick = { /*TODO*/ }
                            ) {
                                Text(
                                    text = "Adicionar produto",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }
                        }
                    }
                }
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