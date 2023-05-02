package com.example.taskviewpager.pageadapter

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import com.example.mymusic.fragments.CameraFragment
import com.example.mymusic.fragments.MainFragment
import com.example.mymusic.fragments.MassageFragment
import com.example.mymusic.fragments.NavFragment


class MainPageAdapter(var context: Context, fm:FragmentManager, lifecycle:Lifecycle): FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
                    0 -> {
                            return CameraFragment()
                                }
                    1 -> {
                            return  NavFragment()
                                }

                    2 -> {
                        return MassageFragment()
                                }
                    else -> {
                        Toast.makeText(context, "Something went Wrong!", Toast.LENGTH_SHORT).show()
                          return com.example.mymusic.pageadapter.PostFragment()
                                }
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
        when(position){
            0->{
                return "Camera"
            }
            1->{
                return "Main"

            }
            2->{
                return "Messanger"

            }
            else->{
                return super.getPageTitle(position)
            }
        }
    }

}