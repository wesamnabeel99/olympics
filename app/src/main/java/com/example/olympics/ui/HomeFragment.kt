package com.example.olympics.ui

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.olympics.data.DataManager
import com.example.olympics.databinding.FragmentHomeBinding
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    var selector = 0
    lateinit var adapter: CountryAdapter
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate

    override fun setup() {
        adapter = CountryAdapter(DataManager.countries)
        binding.recyclerView.adapter = adapter
    }

    override fun addCallBacks() {

        binding.apply {
            right.setOnClickListener {
                TransitionManager.beginDelayedTransition(binding.root)
                binding.recyclerView.scrollToPosition(DataManager.countries.lastIndex)
            }
            left.setOnClickListener {
                TransitionManager.beginDelayedTransition(binding.root)
                binding.recyclerView.scrollToPosition(0)
            }
        }
    }






}