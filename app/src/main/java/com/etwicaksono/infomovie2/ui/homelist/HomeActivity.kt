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
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[ListViewModel::class.java]
        viewModel.sort.value = SortUtils.TITLE

        binding.viewPager.adapter = ListPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> startActivity(
                Intent(
                    this@HomeActivity,
                    FavoriteActivity::class.java
                )
            )
            R.id.action_title -> viewModel.sort.value = SortUtils.TITLE
            R.id.action_vote -> viewModel.sort.value = SortUtils.VOTE
            R.id.action_release_date -> viewModel.sort.value = SortUtils.RELEASE_DATE
            R.id.action_random -> viewModel.sort.value = SortUtils.RANDOM
        }
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

}