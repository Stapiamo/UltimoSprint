package com.example.ultimosprint.Repositorio

import com.example.ultimosprint.Database.RestDataSource
import com.example.ultimosprint.Modelo.DetallesProducto
import com.example.ultimosprint.Modelo.Producto
import com.example.ultimosprint.Modelo.ProductoDao
import com.example.ultimosprint.Modelo.Productos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ProductoRepository {
    suspend fun getProductoById(id: Int): DetallesProducto
    suspend fun getAllproductosAPI(): ArrayList<Productos>
    fun getAllProductoRoom(): Flow<List<Producto>>
}


class ProductosRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val productoDao: ProductoDao
): ProductoRepository {
    override suspend fun getProductoById(id: Int): DetallesProducto {
        val data = dataSource.getProductoById(id).body()!!
        val producto = DetallesProducto(
            id = data.id,
            name = data.name,
            price = data.price,
            imageUrl = data.imageUrl,

        )
        return producto
    }

    override suspend fun getAllproductosAPI(): ArrayList<Productos> {
        val data = dataSource.getProductoById()
        data.forEach{
            val producto = Producto(
                it.id,
                it.name,
                it.price,
                it.imageUrl
            )
            productoDao.insert(producto)
        }
        return ArrayList(data)
    }

    override fun getAllProductoRoom(): Flow<List<Producto>> = productoDao.getAll()

}
    }

