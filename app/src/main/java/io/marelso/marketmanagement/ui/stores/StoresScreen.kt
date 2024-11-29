package io.marelso.marketmanagement.ui.stores

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.marelso.marketmanagement.data.Store
import io.marelso.marketmanagement.ui.components.StoreCard

@Composable
fun StoresScreenHoisting(
    viewModel: StoresViewModel
) {
    val stores by viewModel.stores.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    StoresScreen(stores = stores, isLoading = isLoading) {
        viewModel.onStoreClick(it)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun StoresScreen(
    modifier: Modifier = Modifier,
    stores: List<Store>,
    isLoading: Boolean,
    onStoreClick: (Store) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Cadastrar nova loja")
            }
        }
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(PaddingValues(top = 16.dp, start = 16.dp, end = 16.dp))
        ) {
            Text(
                text = "Selecione uma loja",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )
            )

            Text(
                text = "Escolha a loja que deseja acessar",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            )

            if(isLoading) {
                Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if(stores.isNotEmpty()) {
                LazyColumn(
                    contentPadding = PaddingValues(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(stores) {
                        StoreCard(store = it) {
                            onStoreClick(it)
                        }
                    }
                }
            }
        }
    }
}