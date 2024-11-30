package io.marelso.marketmanagement.ui.store.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.marelso.marketmanagement.data.Product
import io.marelso.marketmanagement.data.network.product.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productId: String,
    private val repository: ProductRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.LOADING)
    val uiState: StateFlow<ProductUiState> = _uiState

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch {
        _uiState.emit(ProductUiState.LOADING)

        val result = repository.getProductById(productId)

        if(result.isSuccessful) {
            _product.emit(result.body())
            _uiState.emit(ProductUiState.SUCCESS)
        } else {
            _product.emit(null)
            _uiState.emit(ProductUiState.ERROR)
        }
    }
}

sealed class ProductUiState {
    data object LOADING: ProductUiState()
    data object SUCCESS: ProductUiState()
    data object ERROR: ProductUiState()
}