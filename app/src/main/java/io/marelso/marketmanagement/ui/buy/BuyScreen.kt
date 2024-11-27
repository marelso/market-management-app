package io.marelso.marketmanagement.ui.buy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.marelso.marketmanagement.data.Product
import io.marelso.marketmanagement.ui.components.AppSearchBar
import io.marelso.marketmanagement.ui.components.AppTopBar
import io.marelso.marketmanagement.ui.components.SalesBottomBar
import io.marelso.marketmanagement.ui.components.SalesProduct

data class BuyScreenParameterHolder(
    val products: List<Product>,
    val query: String,
    val onQueryChange: (String) -> Unit,
    val onNavClick: () -> Unit
)

@Composable
fun BuyScreenHoisting(onNavClick: () -> Unit) {
    val products = List(10) {
        Product(
            id = it.toString(),
            name = "#$it product",
            price = it * 2.5,
            storeId = "#$it product"
        )
    }
    var query by remember {
        mutableStateOf("")
    }

    BuyScreen(
        holder = BuyScreenParameterHolder(
            products = products,
            query = query,
            onQueryChange = {
                query = it
            },
            onNavClick = onNavClick
        )
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun BuyScreen(
    modifier: Modifier = Modifier,
    holder: BuyScreenParameterHolder
) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Registrar compra") {
                holder.onNavClick()
            }
        },
        bottomBar = {
            SalesBottomBar()
        }
    ) {
        LazyColumn(
            modifier = modifier.padding(it),
            contentPadding = PaddingValues(bottom = 16.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            stickyHeader {
                Box(modifier.background(MaterialTheme.colorScheme.background).padding(top = 16.dp)) {
                    AppSearchBar(
                        query = holder.query,
                        onSearch = holder.onQueryChange,
                        placeholder = "Procure por nome",
                        onClearClicked = {
                            holder.onQueryChange("")
                        }
                    )
                }
            }

            items(
                items = holder.products,
                key = { it.id }
            ) {
                SalesProduct(product = it) {}
            }
        }
    }
}