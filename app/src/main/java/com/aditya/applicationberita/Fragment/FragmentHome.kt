package com.aditya.applicationberita.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.applicationberita.Adapter.AdapterNews
import com.aditya.applicationberita.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding


    private lateinit var mAdapter: AdapterNews
    private lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        mAdapter = AdapterNews {

        }
getData()

    }

    private fun getData() {
        viewModel.getarticles()
        viewModel.articles.observe(viewLifecycleOwner) {
            Log.d("Response::::::::::::::", "getData: $it")
            mAdapter.submitList(it.articles)
            binding?.apply {
                rvHome.adapter = mAdapter
                rvHome.layoutManager = LinearLayoutManager(context)
                rvHome.setHasFixedSize(true)

            }
        }
    }
}






