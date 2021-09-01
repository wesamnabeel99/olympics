package com.example.olympics.ui

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.olympics.R
import com.example.olympics.data.DataManager
import com.example.olympics.databinding.FragmentHomeBinding
import com.example.olympics.util.Property

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    //region initialize variables
    lateinit var adapter: CountryAdapter
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate
    //endregion

    override fun setup() {
        adapter = CountryAdapter(DataManager.countries)
        binding.recyclerView.adapter = adapter
    }

    override fun addCallBacks() {

        binding.apply {

            //region navigation listeners
            right.setOnClickListener {
                scrollToPosition(DataManager.countries.lastIndex)
            }
            left.setOnClickListener {
                scrollToPosition(0)
            }
            shuffle.setOnClickListener {
                scrollToPosition((0..DataManager.countries.lastIndex).random())
            }
            //endregion

            //region chipGroup listener
            chipGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.winner_chip -> {
                        adapter.updateData(DataManager.countries)
                    }
                    R.id.total_chip -> {
                        adapter.updateData(DataManager.sortCountriesBy(Property.TOTAL))
                    }
                    R.id.gold_chip -> {
                        adapter.updateData(DataManager.sortCountriesBy(Property.GOLD))
                    }
                    R.id.silver_chip -> {
                        adapter.updateData(DataManager.sortCountriesBy(Property.SILVER))
                    }
                    R.id.bronze_chip -> {
                        adapter.updateData(DataManager.sortCountriesBy(Property.BRONZE))
                    }
                }
            }
            //endregion

        }
    }
    //region functions
    /**
     * this function will scroll for given position in the recycler view
     * @param position:Int the position you want to scroll to
     * @return Unit
     * @author Wesam N. Shawqi
     */
    private fun scrollToPosition(position:Int) {
        TransitionManager.beginDelayedTransition(binding.root)
        binding.recyclerView.scrollToPosition(position)
    }

    //endregion
}