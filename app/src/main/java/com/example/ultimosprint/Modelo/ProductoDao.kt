package com.example.ultimosprint.Modelo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert (producto: Producto)

    @Query("SELECT * FROM Producto ORDER BY id")
    fun getAll(): Flow<List<Producto>>

}

