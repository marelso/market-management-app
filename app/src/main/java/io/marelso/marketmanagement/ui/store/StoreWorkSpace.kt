package io.marelso.marketmanagement.ui.store

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.marelso.marketmanagement.data.navigate
import io.marelso.marketmanagement.navigation.Routes
import io.marelso.marketmanagement.ui.components.StoreBottomNav
import io.marelso.marketmanagement.ui.store.navigation.StoreNavGraph
import io.marelso.marketmanagement.ui.store.navigation.StoreRoutes
import io.marelso.marketmanagement.ui.theme.Brand

@Composable
fun StoreWorkSpaceHoisting(
    onSheetOptionClick: (Routes) -> Unit
) {
    val navHostController: NavHostController = rememberNavController()
    val navOptions = listOf(
        StoreRoutes.Home,
        StoreRoutes.Stock,
        StoreRoutes.Entries,
        StoreRoutes.Settings
    )
    val route = navHostController.currentBackStackEntryAsState().value?.destination?.route
    val current = when (route) {
        StoreRoutes.Stock.route -> StoreRoutes.Stock
        StoreRoutes.Entries.route -> StoreRoutes.Entries
        StoreRoutes.Settings.route -> StoreRoutes.Settings
        else -> StoreRoutes.Home
    }
    var isBottomSheetVisible by remember {
        mutableStateOf(false)
    }

    StoreWorkSpace(
        navHostController = navHostController,
        navOptions = navOptions,
        current = current,
        isBottomSheetVisible = isBottomSheetVisible,
        onItemClick = {
            current.apply {
                navHostController.navigate(navigate(it))
            }
        },
        onActionClick = {
            isBottomSheetVisible = it
        },
        onSheetOptionClick = onSheetOptionClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StoreWorkSpace(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    navOptions: List<StoreRoutes>,
    current: StoreRoutes,
    isBottomSheetVisible: Boolean,
    onItemClick: (StoreRoutes) -> Unit,
    onActionClick: (Boolean) -> Unit,
    onSheetOptionClick: (Routes) -> Unit
) {
    Scaffold(bottomBar = {
        StoreBottomNav(
            options = navOptions,
            selected = current,
            onItemClick = onItemClick,
            onActionClick = onActionClick
        )
    }) {
        Box(modifier.padding(it)) {
            StoreNavGraph(navHostController = navHostController)
            if(isBottomSheetVisible) {
                ModalBottomSheet(onDismissRequest = { onActionClick(false) }) {
                    Box(
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { onSheetOptionClick(Routes.Buy) }) {
                        Text(
                            text = "Registrar compra",
                            style = MaterialTheme.typography.labelLarge,
                            color = Brand
                        )
                    }

                    Divider()

                    Box(
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { onSheetOptionClick(Routes.Sell) }) {
                        Text(
                            text = "Registrar venda",
                            style = MaterialTheme.typography.labelLarge,
                            color = Brand
                        )
                    }
                }
            }
        }
    }
}