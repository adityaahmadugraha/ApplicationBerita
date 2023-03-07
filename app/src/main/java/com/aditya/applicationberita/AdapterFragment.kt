package com.aditya.applicationberita

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterFragment(fragment : Fragment)
    : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
       var fragment = Fragment()
        when(position) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
        }
        return fragment
    }

}