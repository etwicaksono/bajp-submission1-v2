package com.etwicaksono.infomovie2.ui.list

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.utils.Helper

class ListPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return ListFragment.newInstance(TAB_TITLES[position])
    }

    override fun getPageTitle(position: Int): CharSequence {
        return TAB_TITLES[position]
    }


    companion object {
        private val TAB_TITLES = listOf(Helper.TYPE_MOVIE, Helper.TYPE_TVSHOW)
    }
}