package io.marelso.marketmanagement.ui.stores

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.marelso.marketmanagement.data.Store
import io.marelso.marketmanagement.data.network.store.StoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StoresViewModel(private val repository: StoreRepository): ViewModel() {
    private val _stores = MutableStateFlow<List<Store>>(listOf())
    val store: StateFlow<List<Store>> = _stores

    init {
        viewModelScope.launch {
            val result = repository.getUserStores()

            if(result.isSuccessful) {
                _stores.tryEmit(result.body() ?: listOf())
            }
        }
    }
}