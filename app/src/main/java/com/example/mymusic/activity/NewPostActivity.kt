package com.example.mymusic.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mymusic.R
import com.example.mymusic.databinding.ActivityNewPostBinding

class NewPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var back = binding.backBtnNewPost
        var post = binding.postCheckImage

        back.setOnClickListener { onBackPressed() }
        post.setOnClickListener {
           var nav =  supportFragmentManager.findFragmentById(R.id.host_fragment_container)
            navigateUpTo(intent)
        }
    }
}