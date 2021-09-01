package com.example.olympics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB:ViewBinding> :Fragment(){
    abstract val bindingInflater : (LayoutInflater,ViewGroup?,Boolean) -> VB
    private var _binding:ViewBinding?=null
    protected val binding
    get()= _binding as VB

    abstract val LOG_TAG:String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (container != null) {
            container.removeAllViews(); //to fix fragments stacking issue
        }

        _binding = bindingInflater(inflater,container,false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        addCallBacks()
    }
    abstract fun addCallBacks()
    abstract fun setup()
}