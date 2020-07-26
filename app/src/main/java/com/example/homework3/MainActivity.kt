package com.example.homework3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.Key


class MainActivity : AppCompatActivity(), View.OnClickListener{

    private var drinks: MutableList<Result> = ArrayList()
    private var drinksAdapter: DrinksAdapter = DrinksAdapter(drinks, ::drinkDetails)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxtSearch.setOnKeyListener { view: View, i: Int, keyEvent: KeyEvent ->

            if (i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_UP) {

                submit()
                hideKeyboard()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false

        }



        submit_search.setOnClickListener(this)
//        recyclerView.apply {
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = drinksAdapter
//        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = drinksAdapter
    }

    override fun onClick(button: View?) {
        when(button?.id) {
            R.id.submit_search -> {
                submit()
                hideKeyboard()
            }
        }
    }


    private fun AppCompatActivity.hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

    }
    private fun drinkDetails(drink : Result) {
        val intent = Intent(this, DrinkDetails::class.java)
        intent.putExtra("DRINK", drink)
        startActivity(intent)


    }
    private fun onSuccess(drinks: List<Result>?) {

        recyclerView.adapter = drinks?.toMutableList()?.let { DrinksAdapter(it, ::drinkDetails) }
        progress_bar.visibility = View.GONE
        if (drinks != null) {
            drinksAdapter.appendDrinks(drinks)
        }
        else {
            onError()
        }

        }
    private fun onError() {
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show()
        }
    private fun submit() {

        var searchTerms = editTxtSearch.text.toString()


        val newRequest = ServiceBuilder.buildService()
        val newCall = newRequest.searchDrinks(searchTerms)

        newCall.enqueue(object : Callback<Drinks> {
            override fun onFailure(call: Call<Drinks>, t: Throwable) {


            }

            override fun onResponse(call: Call<Drinks>, response: Response<Drinks>) {
                if (response.isSuccessful) {
                    if (response.body()?.drinks?.size != 0) {

                        onSuccess(response.body()?.drinks)

                    } else {
                        onError()
                    }
                }
                else {
                    onError()
                }
            }

        })
    }
}