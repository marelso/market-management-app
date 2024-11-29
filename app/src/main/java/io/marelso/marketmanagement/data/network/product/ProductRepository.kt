package io.marelso.marketmanagement.data.network.product

import androidx.paging.Pager
import androidx.paging.PagingConfig
import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.Store

class ProductRepository(
    private val service: ProductService,
    private val store: Store,
) {
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
}