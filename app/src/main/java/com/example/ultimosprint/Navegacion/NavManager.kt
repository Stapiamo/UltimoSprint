package com.example.ultimosprint.Navegacion

import androidx.navigation.NavHostController

object NavManager {
    lateinit var navController: NavHostController

    fun iniciar(navController: NavHostController) {
        this.navController = navController
    }

    fun navegar(ruta: String) {
        navController.navigate(ruta)
    }

    fun regresar() {
        navController.popBackStack()
    }
}
