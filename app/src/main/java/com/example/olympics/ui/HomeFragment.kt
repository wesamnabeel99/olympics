package com.example.olympics.ui

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
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
                scrollToPosition(DataManager.countries.lastIndex)
            }
            left.setOnClickListener {
                scrollToPosition(0)
            }
            shuffle.setOnClickListener {
                scrollToPosition((0..DataManager.countries.lastIndex).random())
            }

            winnerChip.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    adapter.setData(DataManager.countries)
                }
            }
            totalChip.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    adapter.setData(DataManager.countries.sortedByDescending { it.total })
                }
            }
            goldChip.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    adapter.setData(DataManager.countries.sortedByDescending { it.gold })
                }
            }
            silverChip.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    adapter.setData(DataManager.countries.sortedByDescending { it.silver })
                }
            }
            bronzeChip.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    adapter.setData(DataManager.countries.sortedByDescending { it.bronze })
                }
            }


        }
    }

    fun scrollToPosition(position:Int) {
        TransitionManager.beginDelayedTransition(binding.root)
        binding.recyclerView.scrollToPosition(position)

    }



}