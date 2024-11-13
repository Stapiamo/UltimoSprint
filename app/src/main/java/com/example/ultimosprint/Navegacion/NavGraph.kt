package com.example.ultimosprint.Navegacion


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ultimosprint.Vista.DetallesProductoView
import com.example.ultimosprint.Vista.ListaProductosView


@Composable
fun NavGraph(
    viewModel: ProductoViewModel,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavManager.iniciar(navController)

    NavHost(
        navController = navController,
        startDestination = Rutas.ListaProductos,
        modifier = modifier
    ) {
        composable(Rutas.ListaProductos) {
            ListaProductosView(navController, viewModel)
        }
        composable(
            route = Rutas.DetallesProducto,
            arguments = listOf(navArgument("productoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productoId = backStackEntry.arguments?.getInt("productoId") ?: 0
            DetallesProductoView(productoId, viewModel)
        }
    }
}
