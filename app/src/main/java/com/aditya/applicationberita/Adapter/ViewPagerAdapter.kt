package com.aditya.applicationberita.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val FragmentHome = ArrayList<Fragment>()
    private val LikeFragment = ArrayList<String>()

    override fun getCount(): Int {
        return FragmentHome.size
    }

    override fun getItem(position: Int): Fragment {
        return FragmentHome[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return LikeFragment[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        FragmentHome.add(fragment)
        LikeFragment.add(title)
    }
}