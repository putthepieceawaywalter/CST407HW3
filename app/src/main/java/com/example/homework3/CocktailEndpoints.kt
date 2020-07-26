package com.example.homework3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CocktailEndpoints {
    @GET("search.php")
    fun searchDrinks(
        @Query("s") searchTerms: String)
//        onSuccess: (drinks: List<Result>) -> Unit,
//        onError: () -> Unit)
            : Call<Drinks>
    //fun getRandom(@Query("s") searchTerms: String): Call<Drinks>
}