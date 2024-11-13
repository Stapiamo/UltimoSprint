package com.example.ultimosprint.Network

import com.example.ultimosprint.Modelo.DetallesProducto
import com.example.ultimosprint.Modelo.Producto
import retrofit2.http.GET
import retrofit2.http.Path

// para llamar a la api
interface ApiService {
    @GET("products")
    suspend fun obtenerProductos(): List<Producto>

    @GET("details/{id}")
    suspend fun obtenerDetallesProducto(@Path("id") id: Int): DetallesProducto
}
