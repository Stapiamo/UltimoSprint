package com.example.ultimosprint.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ultimosprint.Modelo.Producto
import com.example.ultimosprint.Modelo.ProductoDao


@Database(entities = [Producto::class], version = 1)
    abstract class DataSource: RoomDatabase() {
        abstract fun productoDao(): ProductoDao
    }