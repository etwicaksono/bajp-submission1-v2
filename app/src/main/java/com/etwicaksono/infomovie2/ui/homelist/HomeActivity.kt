package com.etwicaksono.infomovie2.ui.homelist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.databinding.ActivityHomeListBinding
import com.etwicaksono.infomovie2.ui.favoritelist.FavoriteActivity
import com.etwicaksono.infomovie2.utils.Helper.TAB_TITLES
import com.etwicaksono.infomovie2.utils.SortUtils
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.viewPager.adapter = ListPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }
}