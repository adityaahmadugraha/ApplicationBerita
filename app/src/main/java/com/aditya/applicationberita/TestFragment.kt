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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }






}