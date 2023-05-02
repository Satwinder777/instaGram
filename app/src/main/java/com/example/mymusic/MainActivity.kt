package com.example.mymusic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TableLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.example.mymusic.adapter.PageAdapter
import com.example.mymusic.adapter.RecyclerAdapter
import com.example.mymusic.adapter.RecyclerAdapter2
import com.example.mymusic.adapter.ShareAdapter
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.databinding.ActivityMainBinding
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusicobject.Helper
import com.example.taskviewpager.pageadapter.MainPageAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val AccessKey = "LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU"
 const val SecretKey = "wA5_P1ZoG0YCm3VLSlyruyR4XJQaiMH05MqavczqdGM"
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /******/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val viewPager = binding.viewPage0
        viewPager.adapter = MainPageAdapter(
            this,
            supportFragmentManager,
            lifecycle
        )
        viewPager.currentItem = 1

        val tabLayout = binding.tabLayout0

        tabLayout.setupWithViewPager(viewPager)

    }
}