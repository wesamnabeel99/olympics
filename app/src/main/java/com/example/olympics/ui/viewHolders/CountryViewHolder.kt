package com.example.olympics.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.olympics.R
import com.example.olympics.databinding.ItemCountryBinding

class CountryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val binding = ItemCountryBinding.bind(viewItem)
}