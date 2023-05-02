package com.example.mymusic.activity

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mymusic.R
import com.example.mymusic.databinding.ActivityStroyBinding
import com.example.mymusic.fragments.MainFragment


class StoryActivity : AppCompatActivity() {
    private lateinit var binding :ActivityStroyBinding
    private lateinit var listVideos:List<String>
    private lateinit var progressBar : ProgressBar
    var a = 0

    var k = MainFragment().a
    var pTime = 0
    val handler = Handler()
    var posthand:Boolean? = null
//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStroyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    var storyIndex =  intent.getIntExtra("position",-1)

    a=storyIndex

//    val name = intent.getStringExtra("name")
//    val age = intent.getIntExtra("index",7)



    // Use the data
    Log.d("sherOkk", "dhjsbchjdsbc"+storyIndex)



    listVideos = listOf<String>(
            "android.resource://" + packageName + "/" + R.raw.video1,
            "android.resource://" + packageName + "/" + R.raw.video2,
            "android.resource://" + packageName + "/" + R.raw.video3,
            "android.resource://" + packageName + "/" + R.raw.video4,
            "android.resource://" + packageName + "/" + R.raw.video5,
            "android.resource://" + packageName + "/" + R.raw.video6,
            "android.resource://" + packageName + "/" + R.raw.video7,
        )



        binding.videoView.setVideoURI(Uri.parse(listVideos[a]))
        binding.videoView.start()





        binding.cardv.setOnClickListener {
            if (binding.videoView.isPlaying) {
                binding.videoView.pause()
                pTime=pTime
                handler.removeCallbacksAndMessages(null);
                println("if")
            } else {
                binding.videoView.start()
                    handle()
                println("else")
            }
        }
        binding.item1.setOnClickListener {
            if (a>1){
                a--
                }else{
                 a=0
            }

//            binding.videoView.stopPlayback()
             binding.videoView.stopPlayback()
            binding.videoView.setVideoURI(Uri.parse(listVideos[a]))
            binding.videoView.start()
            pTime=0

            Log.e("satta", "onCreate: \"item one is clicked\"")
        }

        binding.item2.setOnClickListener {
            if (a<listVideos.size-1){
                a++
            }
            else {
                a=6
                Toast.makeText(this, "done!", Toast.LENGTH_SHORT).show()
            }

           binding.videoView.stopPlayback()
            binding.videoView.setVideoURI(Uri.parse(listVideos[a]))
            binding.videoView.start()
            Log.e("satta", "onCreate: \"item second is clicked\"")
           pTime=0
        }

        binding.videoView.setOnCompletionListener {

            binding.videoView.setVideoURI(Uri.parse(listVideos[a]))

            if (a<=listVideos.size){
                binding.videoView.start()
            }
            else{
                binding.videoView.pause()
            }
            if (a<listVideos.size-1){
                a++
            }
            pTime=0
        }



        val progressBar = findViewById<ProgressBar>(R.id.progressBar)



        progressBar.progress = 0

        progressBar.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.sky))
        val TAG2 = "check22"

//       var t2 = 100/t1
        progressBar.max = 100

        handle()

//    Log.e("sher", "onCreate: $storyIndex", )

    Log.d("sher", "Name: $k")
    }


    private fun handle(){
        var data = listOf<Int>(R.raw.video1, R.raw.video2, R.raw.video3, R.raw.video4, R.raw.video5, R.raw.video6, R.raw.video7)
        val TAG = "check21"
        handler.postDelayed(object : Runnable {
            override fun run() {
                val mpl: MediaPlayer = MediaPlayer.create(this@StoryActivity,data[a])

//                progressBar = binding.progressBar
//                val zzz = mpl.duration/1000
                var zzz = mpl.duration/1000

                var t1 =  100/zzz
                var t2 =  t1
                pTime+=t2

                binding.progressBar.progress = pTime

                Log.e(TAG, "run: progress ${k}")
//                Log.e(TAG, "run:index ${a}")
//                Log.e(TAG, "run: second : ${zzz}")
                handler.postDelayed(this, 1000)

            }
        }, 0)

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null);
    }



}






//    @RequiresApi(Build.VERSION_CODES.R)
//    private fun check1() {
//        if (binding.videoView.hasOnLongClickListeners()){
//            binding.videoView.pause()
//        }
//        else{
//            binding.videoView.start()
//
//        }
//    }


//}