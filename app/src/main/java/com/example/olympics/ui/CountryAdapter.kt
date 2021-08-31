package com.example.olympics.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.olympics.R
import com.example.olympics.data.domain.Country
import com.example.olympics.databinding.ItemCountryBinding

class CountryAdapter(var list : List<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    //region override abstract function
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = list[position]
        //region binding the data to ui
        holder.binding.apply {
            countryTextView.text = currentCountry.country.toCharArray().filter { it !='\"' }.joinToString("") //to remove double qutations from strings
            rankTextView.text= "Rank:" + currentCountry.rank.toString()
            rankByTotalTextView.text = "Rank By Total:"+ currentCountry.rankByTotal.toString()
            goldTextView.text = currentCountry.gold.toString()
            silverTextView.text = currentCountry.silver.toString()
            bronzeTextView.text = currentCountry.bronze.toString()
            totalTextView.text = "Total:"+currentCountry.total.toString()
        }
        //endregion
    }


    override fun getItemCount() = list.size
//endregion

    //region functions
    /**
     * this function update the data in recycler view with new list using DiffUtil
     * @param newList :List<Country> passed to update the list
     * @return Unit
     * @author Wesam N. Shawqi
     */
    fun updateData(newList:List<Country>) {
        val diffrentResult = DiffUtil.calculateDiff(CountryDiffUtil(list,newList))
        list = newList
        diffrentResult.dispatchUpdatesTo(this)
    }
    //endregion

    //region CountryViewHolder Class
    class CountryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemCountryBinding.bind(viewItem)
    }
    //endregion

}