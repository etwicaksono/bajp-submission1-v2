package com.etwicaksono.infomovie2.ui.favoritelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.databinding.ActivityFavoriteListBinding
import com.etwicaksono.infomovie2.utils.Helper.TAB_TITLES
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFavoriteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.favorite)
        }

        binding.viewPager.adapter = FavoriteListPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }

}