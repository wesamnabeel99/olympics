package com.example.olympics.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.olympics.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate

    override fun addCallBacks() {

    }



}