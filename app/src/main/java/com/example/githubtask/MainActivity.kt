package com.example.githubtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubtask.adapter.ViewPagerAdapter
import com.example.githubtask.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
