package com.aditya.applicationberita.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aditya.applicationberita.Fragment.FragmentHome
import com.aditya.applicationberita.Fragment.LikeFragment
import com.aditya.applicationberita.MainActivity

class AdapterFragment(fragment: MainActivity)
    : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
       var fragment = Fragment()
        when(position) {
            0 -> fragment = FragmentHome()
            1 -> fragment = LikeFragment()
        }
        return fragment
    }

}