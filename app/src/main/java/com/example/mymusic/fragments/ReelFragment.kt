package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.adapter.CommentAdapter3
import com.example.mymusic.adapter.CommentAdapter6
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.databinding.FragmentReelBinding
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusicobject.Helper
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ReelFragment : Fragment() {
    private lateinit var binding: FragmentReelBinding
    private lateinit var adapter: CommentAdapter6
    private lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Unsplaceapi>
//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var postbtn: TextView
    private lateinit var process: ProgressBar
    private var count = 999
    var a = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var reelvideo = binding.reelvideoView
        var reellike = binding.reellike
        var reellikeCount = binding.reellikeCount
        var reelcomment = binding.commentbtn
        var reelcommentCount = binding.commentCount
        var reelshare = binding.reelsharebtn
        var reelshareCount = binding.reellikeCount
        var reelmore = binding.moreReelBtn
        var followtxt =binding.followtxt



        var bottomSheet = view.findViewById<ConstraintLayout>(R.id.bottomsheetreel)
//        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        reellike.setOnClickListener {
            if (a == true) {
                reellike.setImageResource(R.drawable.baseline_favorite_24)
                reellikeCount.text = count++.toString().plus(" likes")
                a = false
            } else {
                reellike.setImageResource(R.drawable.white_heart)
                reellikeCount.text = count--.toString().plus(" likes")
                a = true
            }
        }
        var packageName = requireContext().packageName

        val videoPath = "android.resource://" + packageName + "/" + R.raw.video1
        reelvideo.setVideoPath(videoPath)
        reelvideo.start()
        reelvideo.setOnCompletionListener {
            val videoPath = "android.resource://" + packageName + "/" + R.raw.video1
            reelvideo.setVideoPath(videoPath)
            reelvideo.start()
        }
        var isFollowed = false
        followtxt.setOnClickListener {
            if (isFollowed==false){
                followtxt.text = "Following"
                isFollowed =true
            }
            else{
                followtxt.text = "Follow"
                isFollowed = false
            }
        }


        //////


//        recyclerView = view.findViewById(R.id.reelcommentrecycler)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        list = mutableListOf()
//        recyclerView.adapter = adapter
//
//        adapter = CommentAdapter6(list)
//        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                when (newState) {
////                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@MainActivity, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
////                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText( this@MainActivity, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
////                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@MainActivity, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
////                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(this@MainActivity, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
////                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@MainActivity, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
//                    else -> Toast.makeText(requireContext(), "OTHER_STATE", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
////                Toast.makeText(this@MainActivity, "toast", Toast.LENGTH_SHORT).show()
//            }
//        })

//        var edit = findViewById<EditText>(R.id.editComment)
//        process.visibility = View.INVISIBLE

//        postbtn = findViewById(R.id.postbtn)

       var  btnShowBottomSheet = binding.commentbtn

        // adding on click listener for our button.
//        btnShowBottomSheet.setOnClickListener {
//
//
//                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED){
//                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//
//                }
//                else{
//                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//
//                }
//
//            val request = Helper.getResp()
//
//            var interface2 = request.create(uspInterface::class.java)
//            var call: Call<Unsplaceapi> = interface2.getImage()
//
//            call.enqueue(object : Callback<Unsplaceapi> {
//                @SuppressLint("NotifyDataSetChanged")
//                override fun onResponse(call: Call<Unsplaceapi>, response: Response<Unsplaceapi>) {
//                    process.visibility = View.INVISIBLE
//
//                    list.clear()
//                    var length = response.body()!!
//                    for (myData in 0..length.size - 1) {
//                        list.add(length)
//                        recyclerView.adapter = adapter
//                        adapter.notifyDataSetChanged()
//                        Log.e("code", "onResponse: ${response.code()}",)
//                    }
//                }
//                override fun onFailure(call: Call<Unsplaceapi>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//
//            recyclerView.adapter = adapter
//
//            // on below line we are creating a new bottom sheet dialog.
//            val dialog = BottomSheetDialog(requireContext())
//
//            // on below line we are inflating a layout file which we have created.
//            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
//
//
////            val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)
//
//
////            btnClose.setOnClickListener {
//
////                dialog.dismiss()
////            }
//
//            dialog.setCancelable(false)
//
//            dialog.setContentView(view)
//
//            dialog.show()
//        }

    }
}