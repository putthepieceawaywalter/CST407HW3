package com.example.homework3

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {
//    private val client = OkHttpClient.Builder().build()

    private val cocktailEndpoints:CocktailEndpoints
    init {

        val retrofit = Retrofit.Builder()

            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        cocktailEndpoints = retrofit.create(CocktailEndpoints::class.java)
    }


    fun buildService(): CocktailEndpoints{
        return cocktailEndpoints
    }

}