package com.example.mymusic.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mymusic.R
import com.example.mymusic.adapter.PageAdapter
import com.google.android.material.tabs.TabLayout
import kotlin.concurrent.fixedRateTimer

class ViewPagerActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_view_pager, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        viewPager?.adapter = PageAdapter(fragmentManager,lifecycle)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        tabLayout?.setupWithViewPager(viewPager)
    }


}