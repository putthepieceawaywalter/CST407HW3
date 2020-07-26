package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_drink_details.*

class DrinkDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_details)

        val drink : Result = intent.getSerializableExtra("DRINK") as Result

        drink_name.text = drink.strDrink
        drink_instructions.text = drink.strInstructions
        ingredient_one.text = drink.strIngredient1
        ingredient_two.text = drink.strIngredient2
        ingredient_three.text = drink.strIngredient3

        measure_one.text = drink.strMeasure1
        measure_two.text = drink.strMeasure2
        measure_three.text = drink.strMeasure3
    }
}