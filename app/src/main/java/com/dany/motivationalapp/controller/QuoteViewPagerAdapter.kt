package com.dany.motivationalapp.controller

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dany.motivationalapp.QuoteFragment

class QuoteViewPagerAdapter(fm: FragmentManager, fragments: ArrayList<QuoteFragment>): FragmentPagerAdapter(fm) {

    var fragmentList: ArrayList<QuoteFragment> = fragments

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}