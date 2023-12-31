package com.example.githubtask.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.githubtask.ui.fragments.DayFragment
import com.example.githubtask.ui.fragments.MonthFragment
import com.example.githubtask.ui.fragments.WeekFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                DayFragment()
            }
            1->{
                WeekFragment()
            }
            2->{
                MonthFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}