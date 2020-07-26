package com.example.homework3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class DrinksAdapter(val drinks: MutableList<Result>, private var onDrinkClick: (drink: Result) -> Unit): RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_layout, parent, false)
        return DrinksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        return holder.bind(drinks[position])
    }


    inner class DrinksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photo: ImageView = itemView.findViewById(R.id.drink_photo)
        private val title: TextView = itemView.findViewById(R.id.drink_name)


        fun bind(drinks: Result) {
            Glide.with(itemView.context).load(drinks.strDrinkThumb).into(photo)
            title.text = drinks.strDrink

            itemView.setOnClickListener{
                onDrinkClick.invoke(drinks)
            }


        }

    }
    fun appendDrinks(drinks: List<Result>) {
        this.drinks.addAll(drinks)
        notifyItemRangeInserted(this.drinks.size, drinks.size)
    }
}