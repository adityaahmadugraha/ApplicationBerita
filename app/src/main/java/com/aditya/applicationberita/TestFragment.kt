package com.aditya.applicationberita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.applicationberita.databinding.FragmentTestBinding
import com.google.android.material.tabs.TabLayoutMediator


class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get()= _binding!!
    private lateinit var adapterFragment : AdapterFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterFragment = AdapterFragment(this)

        with(binding){
            viewPager.adapter = adapterFragment

            TabLayoutMediator(tabLayout, viewPager) {tab, position ->
                when (position) {
                    0 -> tab.text = "Berita Hari Ini"
                    1 -> tab.text = "LIKE"
                }
            }.attach ()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}