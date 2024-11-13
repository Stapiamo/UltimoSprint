package com.example.ultimosprint.Modelo


data class ApiResponse(
    val result: ArrayList<Productos>
)
//producto//
data class Productos(
    val id: Int,
    val name: String,
    val price: String,
    val imageUrl: String
)

// DetallesProducto//
data class DetallesProducto(
    val id: Int,
    val name: String,
    val price: String,
    val imageUrl: String
)
