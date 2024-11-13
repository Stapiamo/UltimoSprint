package com.example.ultimosprint.Database

import com.example.ultimosprint.Modelo.DetallesProducto
import com.example.ultimosprint.Modelo.Productos
import com.example.ultimosprint.Util.Constants.Companion.ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface RestDataSource {

    @GET(ENDPOINT)
    suspend fun getEquipos(): List<Productos>

    @GET("$ENDPOINT/{id}")
    suspend fun getProductoById(@Path(value = "id") id: Int): Response<DetallesProducto>


}