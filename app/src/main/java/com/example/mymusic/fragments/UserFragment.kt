package com.example.mymusic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mymusic.R
import com.example.mymusic.databinding.FragmentUserBinding
import com.example.taskviewpager.pageadapter.PageAdapter
import com.google.android.material.tabs.TabLayout

class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding
    private lateinit var tabLayout : TabLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        viewPager.adapter = PageAdapter(requireContext(),childFragmentManager,lifecycle)
        viewPager.currentItem = 0
        tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.grid)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.reel_png)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.tag_png)



    }


}