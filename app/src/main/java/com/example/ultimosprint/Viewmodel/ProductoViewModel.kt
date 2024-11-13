package com.example.ultimosprint.Viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ultimosprint.Modelo.Producto
import com.example.ultimosprint.Repositorio.ProductoRepository
import com.example.ultimosprint.State.ProductoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


@HiltViewModel
class ProductoViewModel @Inject constructor(
    private val repo: ProductoRepository
): ViewModel() {

    var state by mutableStateOf(ProductoState())
        private set

    val equipos: Flow<List<Producto>> by lazy {
        repo.getAllProductoRoom()
    }

    init {
        getAllAPI()
    }

    private fun getAllAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllproductosAPI()
        }
    }

    fun getEquipoById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repo.getProductoById(id)
            state = state.copy(
                name = result.name,
                price = result.price,
                imageUrl = result.imageUrl

            )
        }
    }

    fun clean() {
        state = state.copy(
            name = "",
            price = "",
            imageUrl = ""
        )
    }

}