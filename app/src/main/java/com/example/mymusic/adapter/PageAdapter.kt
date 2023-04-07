package com.example.mymusic.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mymusic.fragments.CameraFragment
import com.example.mymusic.fragments.MainFragment
import com.example.mymusic.fragments.MassageFragment

class PageAdapter
    (var context: Context,fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CameraFragment()
            1 -> return MainFragment()
            2 -> return MassageFragment()
            else -> return MainFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> return "camera"
            1-> return "Instagram"
            2-> return "massages"
            else-> return super.getPageTitle(position)
        }
    }
}