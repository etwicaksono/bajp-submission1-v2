package com.etwicaksono.infomovie2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.etwicaksono.infomovie2.databinding.ActivityHomeBinding
import com.etwicaksono.infomovie2.ui.list.ListPagerAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPagerAdapter = ListPagerAdapter(supportFragmentManager)
        binding.apply {
            viewPager.adapter = listPagerAdapter
            tabs.setupWithViewPager(binding.viewPager)
        }
    }
}