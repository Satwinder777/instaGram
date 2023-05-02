package com.example.mymusic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.mymusic.R
import com.example.mymusic.databinding.FragmentUserBinding
import com.example.taskviewpager.pageadapter.PageAdapter
import com.google.android.material.tabs.TabLayout

class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding


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

        val tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
    }


}