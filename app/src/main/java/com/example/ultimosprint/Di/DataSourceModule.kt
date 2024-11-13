package com.example.ultimosprint.Di

import android.content.Context
import androidx.room.Room
import com.example.ultimosprint.Database.RestDataSource
import com.example.ultimosprint.Util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.ultimosprint.Database.DataSource
import com.example.ultimosprint.Modelo.ProductoDao

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun restDataSource(retrofit: Retrofit): RestDataSource =
        retrofit.create(RestDataSource::class.java)

    @Singleton
    @Provides
    fun dataSource(@ApplicationContext context: Context): DataSource {
        return Room.databaseBuilder(
            context,
            DataSource::class.java,
            "productos_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun ProductoDao(db: DataSource): ProductoDao = db.productoDao()

}