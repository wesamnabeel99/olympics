package com.example.olympics.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.olympics.data.DataManager
import com.example.olympics.data.domain.Country
import com.example.olympics.databinding.FragmentHomeBinding
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    lateinit var adapter: CountryAdapter
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate

    override fun addCallBacks() {
        adapter = CountryAdapter(DataManager.countries)
        binding.recyclerView.adapter = adapter
    }






}