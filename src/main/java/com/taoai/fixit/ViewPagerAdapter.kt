package com.taoai.fixit

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()
    private val icons = ArrayList<Int>()

    fun addFragment(fragment: Fragment, title: String, icon: Int) {
        fragments.add(fragment)
        titles.add(title)
        icons.add(icon)
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }

    fun getIcon(position: Int): Int {
        return icons[position]
    }
}