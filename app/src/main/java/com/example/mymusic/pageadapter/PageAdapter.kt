package com.example.taskviewpager.pageadapter

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import com.example.mymusic.fragments.PostFragment
import com.example.mymusic.fragments.ReelFragment
import com.example.mymusic.pageadapter.TagedPostFragment
import androidx.core.content.ContextCompat


class PageAdapter(var context: Context, fm:FragmentManager,lifecycle:Lifecycle): FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
                    0 -> {
                            return com.example.mymusic.pageadapter.PostFragment()
                                }
                    1 -> {
                            return com.example.mymusic.pageadapter.ReelFragment()
                                }

                    2 -> {
                        return TagedPostFragment()
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
                return "Posts"
            }
            1->{
                return "Reels"

            }
            2->{
                return "TagedPosts"

            }
            else->{
                return super.getPageTitle(position)
            }
        }
    }

}