package com.example.homework3

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Drinks (
    val drinks: List<Result>
)

class Result : Serializable {
    var idDrink: String = ""
    var strDrink: String = ""
    var strCategory: String = ""
    var strIngredient1: String = ""
    var strIngredient2: String = ""
    var strIngredient3: String = ""
    var strIngredent4: String = ""
    var strIngredient5: String = ""

    var strMeasure1: String = ""
    var strMeasure2: String = ""
    var strMeasure3: String = ""
    var strMeasure4: String = ""
    var strMeasure5: String = ""

    var strInstructions: String = ""
    var strGlass: String = ""

    var strDrinkThumb: String = ""

}


