package com.example.olympics.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.olympics.R
import com.example.olympics.data.domain.Country
import com.example.olympics.databinding.ItemCountryBinding

class CountryAdapter(val list : List<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = list[position]
        holder.binding.apply {
            countryTextView.text = currentCountry.country.toCharArray().filter { it !='\"' }.joinToString("")
            rankTextView.text="Rank:"+currentCountry.rank.toString()
            rankByTotalTextView.text = "Rank By Total:"+ currentCountry.rankByTotal.toString()
            goldTextView.text = currentCountry.gold.toString()
            silverTextView.text = currentCountry.silver.toString()
            bronzeTextView.text = currentCountry.bronze.toString()
            totalTextView.text = "Total:"+currentCountry.total.toString()
        }
    }

    override fun getItemCount() = list.size

    class CountryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemCountryBinding.bind(viewItem)
    }
}