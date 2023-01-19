package com.example.myapplication.fragments2

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager2=view.findViewById(R.id.viewPager)
        tabLayout=view.findViewById(R.id.tabLayout)
        viewPagerFragmentAdapter= ViewPagerFragmentAdapter(context as AppCompatActivity)

        viewPager2.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewPager2) {tab, position->
            when (position) {
                0 -> tab.text = "Quotes"
                else -> tab.text = "Profile"
            }


        }.attach()

    }
}