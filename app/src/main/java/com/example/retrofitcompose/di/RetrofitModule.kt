package com.example.retrofitcompose.di

import com.example.retrofitcompose.data.remote.models.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RetrofitModule
{
private val BASE_URL="https://fakestoreapi.com/"
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
         return Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
    }

    @Singleton
    @Provides
    fun  provideProductApi(retrofit: Retrofit):ProductApi
    {
            return retrofit.create(ProductApi::class.java)
    }
}