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
import kotlinx.coroutines.launch

class StoreStockViewModel(private val repository: ProductRepository): ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _price = MutableStateFlow(0.0)
    val price: StateFlow<Double> = _price

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val products = _query.debounce(500L).flatMapLatest {
        repository.getStoreProducts(it)
    }.cachedIn(viewModelScope)

    fun onQueryChanged(value: String) = _query.tryEmit(value)
    fun onNameChanged(value: String) = _name.tryEmit(value)
    fun onPriceChanged(value: String) = _price.tryEmit(value.toDouble())
    fun onSubmit() = viewModelScope.launch {
        repository.
    }
}