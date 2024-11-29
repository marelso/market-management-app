package io.marelso.marketmanagement.ui.store.stock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import io.marelso.marketmanagement.data.network.product.ProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest

class StoreStockViewModel(private val repository: ProductRepository): ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val products = _query.debounce(500L).flatMapLatest {
        repository.getStoreProducts(it)
    }.cachedIn(viewModelScope)

    fun onQueryChanged(value: String) = _query.tryEmit(value)
}