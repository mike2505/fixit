package com.taoai.fixit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.taoai.fixit.databinding.ActivityUserMainBinding

class UserMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = resources.getColor(R.color.welnav)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        adapter.addFragment(DiscoverFragment(), "Discover", R.drawable.home_screen_group_7368)
        adapter.addFragment(ChatFragment(), "Chat", R.drawable.home_screen_group_7371)
        adapter.addFragment(SavedFragment(), "Saved", R.drawable.home_screen_group_7370)
        adapter.addFragment(ProfileFragment(), "Profile", R.drawable.home_screen_group_7369)

        val viewPager = findViewById<ViewPager2>(R.id.pageViewer)
        viewPager.adapter = adapter

        binding.pageViewer.isUserInputEnabled = false
        val tabLayout = findViewById<TabLayout>(R.id.tbLayout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
            tab.setIcon(adapter.getIcon(position))
        }.attach()

        for (i in 0 until binding.tbLayout.tabCount) {
            binding.tbLayout.getTabAt(i)?.setIcon(adapter.getIcon(i))
        }
    }
}