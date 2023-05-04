package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mymusic.R
import com.example.mymusic.databinding.FragmentUserBinding
import com.example.taskviewpager.pageadapter.PageAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout

class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding
    private lateinit var tabLayout : TabLayout
    private lateinit var editProfileCard : CardView
    private lateinit var shareProfileCard : CardView
    private lateinit var menuimguserFragment : ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        viewPager.adapter = PageAdapter(requireContext(),childFragmentManager,lifecycle)
        viewPager.currentItem = 0
        tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
        shareProfileCard = binding.shareProfileCard
        editProfileCard = binding.editProfileCArd
        menuimguserFragment = binding.menuimguserFragment

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.grid)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.reel_png)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.tag_png)

        //opertions

        shareProfileCard.setOnClickListener {  }
        editProfileCard.setOnClickListener {  }
        menuimguserFragment.setOnClickListener {
            var bp = BottomSheetDialog(requireContext())
           var view = layoutInflater.inflate(R.layout.user_menu_dialog,null)
            view.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_popup_bg))

            bp.setContentView(view)
            bp.show()
        }




    }


}