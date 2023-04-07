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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.example.mymusic.adapter.PageAdapter
import com.example.mymusic.adapter.RecyclerAdapter
import com.example.mymusic.adapter.RecyclerAdapter2
import com.example.mymusic.adapter.ShareAdapter
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusicobject.Helper
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val AccessKey = "LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU"
 const val SecretKey = "wA5_P1ZoG0YCm3VLSlyruyR4XJQaiMH05MqavczqdGM"
class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /******/
        setContentView(R.layout.activity_main)

        val viewPager:ViewPager = findViewById(R.id.viewPager)
        var adapter = PageAdapter(this,supportFragmentManager)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(1)

        val pageLayout:TabLayout = findViewById(R.id.tabLayout)
        pageLayout.setupWithViewPager(viewPager)

//        val fragment = MyFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//
//        val position = adapter.getPosition(fragment)
//        viewPager.currentItem = position

    }
}