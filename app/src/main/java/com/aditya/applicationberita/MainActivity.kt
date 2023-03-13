package com.aditya.applicationberita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aditya.applicationberita.Adapter.AdapterFragment
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



}



