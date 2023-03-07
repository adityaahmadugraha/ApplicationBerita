package com.aditya.applicationberita

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditya.applicationberita.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            val fragment = TestFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentaContainer, fragment, TestFragment::class.simpleName)
                .commit()
        }


    }
}