package io.marelso.marketmanagement.ui.store.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.himanshoe.charty.common.ChartData
import com.himanshoe.charty.common.toChartDataCollection
import com.himanshoe.charty.line.CurveLineChart
import io.marelso.marketmanagement.data.Product

@Composable
fun StoreHomeScreenHoisting() {







    StoreHomeScreen()
}

@Composable
private fun StoreHomeScreen() {

    val products = listOf(
        Product(
            id = "Product 1 aa",
            pictureUrl = "Product 1 aa",
            description = "Product 1 aa",
            count = 10,
            name = "Product 1 aa",
            price = 10.0,
            storeId = "Product 1 aa",
        ),
        Product(
            id = "Product 2 aa",
            pictureUrl = "Product 2 aa",
            description = "Product 2 aa",
            count = 6,
            name = "Product 2 aa",
            price = 10.0,
            storeId = "Product 2 aa",
        ),
        Product(
            id = "Product 3 aa",
            pictureUrl = "Product 3 aa",
            description = "Product 3 aa",
            count = 2,
            name = "Product 3 aa",
            price = 10.0,
            storeId = "Product 3 aa",
        ),
        Product(
            id = "Product 4 aa",
            pictureUrl = "Product 4 aa",
            description = "Product 4 aa",
            count = 1,
            name = "Product 4 aa",
            price = 10.0,
            storeId = "Product 4 aa",
        ),
        Product(
            id = "Product 5 aa",
            pictureUrl = "Product 5 aa",
            description = "Product 5 aa",
            count = 5,
            name = "Product 5 aa",
            price = 10.0,
            storeId = "Product 5 aa",
        ),
        Product(
            id = "Product 6 aa",
            pictureUrl = "Product 6 aa",
            description = "Product 6 aa",
            count = 10,
            name = "Product 6 aa",
            price = 10.0,
            storeId = "Product 6 aa",
        ),
    )

    Scaffold {
        Column(Modifier.padding(it)) {
            Text(text = "Home")

            CurveLineChart(
                dataCollection = products.map {
                    ProductChart(
                        xValue = it,
                        yValue = it.count.toFloat(),
                        chartString = it.name,
                    )
                }.toChartDataCollection()
            )
        }
    }
}

data class ProductChart(
    override val chartString: String,
    override val xValue: Any,
    override val yValue: Float
): ChartData