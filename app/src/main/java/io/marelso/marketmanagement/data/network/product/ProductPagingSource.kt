package io.marelso.marketmanagement.data.network.product

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.Product
import java.io.IOException

class ProductPagingSource (
    private val service: ProductService,
    private val storeId: String,
    private val query: String
) : PagingSource<Int, Product>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val page = params.key ?: 0

        val result = service.getProductsByStoreId(
            storeId = storeId,
            query = query,
            page = page,
            size = Constant.PAGE_SIZE
        )

        return if(result.isSuccessful) {
            LoadResult.Page(
                data = result.body()?.content ?: listOf(),
                prevKey = if (page == 0) null else page.minus(1),
                nextKey = if (result.body()?.last == true) null else page.plus(1)
            )
        } else {
            LoadResult.Error(IOException(result.message()))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            anchorPosition / Constant.PAGE_SIZE
        }

}