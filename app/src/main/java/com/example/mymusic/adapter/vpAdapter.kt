package com.example.taskviewpager.pageadapter

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import com.example.mymusic.activity.ViewPagerActivity
import com.example.mymusic.fragments.CameraFragment
import com.example.mymusic.fragments.MainFragment
import com.example.mymusic.fragments.MassageFragment


class PageAdapter1(var context: Context, fm:FragmentManager, lifecycle:Lifecycle): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CameraFragment()
            }
            1 -> {
                return MainFragment()
            }

            2 -> {
                return MassageFragment()
            }
            else -> {
                Toast.makeText(context, "Something went Wrong!", Toast.LENGTH_SHORT).show()
                return MainFragment()
            }
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
        when (position) {
            0 -> {
                return "ActivityFirst"
            }
            1 -> {
                return "ActivitySecond"

            }
            2 -> {
                return "ActivityThird"

            }
            else -> {
                return super.getPageTitle(position)
            }
        }
    }
}

