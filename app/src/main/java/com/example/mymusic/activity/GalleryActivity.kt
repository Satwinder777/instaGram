package com.example.mymusic.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymusic.R
import com.example.mymusic.adapter.GalleryAdapter
import com.example.mymusic.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val directory = File(externalMediaDirs[0].absolutePath)
        val files = directory.listFiles() as Array<File>

// array is reversed to ensure last taken photo appears first.
        val adapter = GalleryAdapter(files.reversedArray())
        binding.viewPager.adapter = adapter
    }
}