package io.marelso.marketmanagement.ui.store.stock

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import io.marelso.marketmanagement.R
import io.marelso.marketmanagement.ui.components.ActionScreen
import io.marelso.marketmanagement.ui.components.AppSearchTopBar
import io.marelso.marketmanagement.ui.components.ProductStockCard
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
            is LoadState.Error -> ActionScreen(
                padding = padding,
                icon = Icons.Default.Warning,
                iconColor = Color.Red,
                title = "There was an error loading your request",
                description = "Reload this page and try again. If this error persists, contact support.",
                onActionClick = { holder.products.retry() }
            )

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
                                .height(68.dp)
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
                    ActionScreen(
                        padding = padding,
                        icon = ImageVector.vectorResource(R.drawable.ic_no_image),
                        description = "Não há nenhum produto com esse nome. Utilize o botão abaixo para registrá-lo.",
                        onActionClick = {  }
                    )
                }
            }
        }
    }
}