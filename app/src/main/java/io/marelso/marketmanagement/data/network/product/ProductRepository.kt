package io.marelso.marketmanagement.data.network.product

import androidx.paging.Pager
import androidx.paging.PagingConfig
import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.CreateProductDto
import io.marelso.marketmanagement.data.Store

class ProductRepository(
    private val service: ProductService,
    private val store: Store,
) {
    suspend fun getProductById(id: String) = service.getProductsById(id)

    fun getStoreProducts(query: String) = Pager(
        pagingSourceFactory = {
            ProductPagingSource(
                service = service,
                storeId = store.id,
                query = query
            )
        },
        config = PagingConfig(pageSize = Constant.PAGE_SIZE)
    ).flow

    suspend fun create(product: CreateProductDto) = service.createProduct(product.copy(storeId = store.id))
}