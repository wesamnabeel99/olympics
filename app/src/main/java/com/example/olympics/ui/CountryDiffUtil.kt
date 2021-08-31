package com.example.olympics.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.olympics.data.domain.Country

class CountryDiffUtil(val mOldList : List<Country> , val mNewList : List<Country>) : DiffUtil.Callback() {

    //region setting lists sizes
    override fun getOldListSize() = mOldList.size
    override fun getNewListSize() = mNewList.size
    //endregion


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].country ==mNewList[newItemPosition].country
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}