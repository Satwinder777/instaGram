package com.example.mymusic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mymusic.R
import com.example.mymusic.databinding.FragmentNavBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NavFragment : Fragment() {
private lateinit var binding: FragmentNavBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNavBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {

            val navHostFragment = childFragmentManager.findFragmentById(R.id.host_fragment_container) as NavHostFragment
            var navController = navHostFragment.navController
            val bottomNavigationView = binding.bNView
            CoroutineScope(Dispatchers.Main).launch {
                NavigationUI.setupWithNavController(bottomNavigationView, navController)
            }
        }





    }


}