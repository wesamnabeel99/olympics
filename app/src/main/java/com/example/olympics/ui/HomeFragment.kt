package com.example.olympics.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.olympics.data.DataManager
import com.example.olympics.data.domain.Country
import com.example.olympics.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate

    override fun addCallBacks() {
        bindCountry(DataManager.returnRandomCountry())
    }

    private fun bindCountry(country:Country) {
        binding.apply {
            countryTextView.text = country.iso
            goldTextView.text = country.gold.toString()
            silverTextView.text = country.silver.toString()
            bronzeTextView.text = country.bronze.toString()
        }
    }


}