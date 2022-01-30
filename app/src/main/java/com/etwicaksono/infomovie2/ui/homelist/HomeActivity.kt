package com.etwicaksono.infomovie2.ui.homelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.etwicaksono.infomovie2.databinding.ActivityHomeBinding
import com.etwicaksono.infomovie2.ui.homelist.ListPagerAdapter
import com.etwicaksono.infomovie2.utils.Helper.TAB_TITLES
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ListPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }

}