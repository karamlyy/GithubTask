package com.example.githubtask.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.githubtask.adapter.ViewPagerAdapter
import com.example.githubtask.databinding.ActivityMainBinding
import com.example.githubtask.viewmodel.SharedViewModel
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter = adapter


        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            when(position){
                0->{
                    tab.text ="Day"
                }
                1->{
                    tab.text="Week"
                }
                2->{
                    tab.text="Month"
                }
            }
        }.attach()
    }



}
