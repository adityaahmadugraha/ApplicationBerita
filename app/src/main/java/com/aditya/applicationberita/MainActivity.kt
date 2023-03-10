package com.aditya.applicationberita

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aditya.applicationberita.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterFragment: AdapterFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = TestFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentaContainer, fragment, TestFragment::class.simpleName)
                .commit()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreateView(view, savedInstanceState)
        adapterFragment = AdapterFragment(this)

        with(binding) {
            viewPager.adapter = adapterFragment

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Berita Hari Ini"
                    1 -> tab.text = "LIKE"
                }
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}