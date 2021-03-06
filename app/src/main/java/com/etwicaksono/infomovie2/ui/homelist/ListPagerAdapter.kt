package com.etwicaksono.infomovie2.ui.homelist

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.etwicaksono.infomovie2.utils.Helper.TAB_TITLES

class ListPagerAdapter(fm: FragmentActivity) :
    FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = TAB_TITLES.size

    override fun createFragment(position: Int): Fragment =
        ListFragment.newInstance(TAB_TITLES[position])

}