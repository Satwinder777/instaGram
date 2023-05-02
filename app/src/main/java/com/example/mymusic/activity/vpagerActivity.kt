package com.example.mymusic.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.mymusic.R
import com.example.taskviewpager.pageadapter.PageAdapter1
import com.google.android.material.tabs.TabLayout

class vpagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vpager)



        val viewPager : ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = PageAdapter1(this.application,supportFragmentManager,lifecycle)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}