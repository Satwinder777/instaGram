package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymusic.R
import com.example.mymusic.adapter.RecyclerAdapter4
import com.example.mymusic.dataClass.searchData


class SearchFragment : Fragment(),RecyclerAdapter4.OnStoryClick {
//    private  var videoView: VideoView?=null
    private lateinit var list: MutableList<searchData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        videoView = view.findViewById(R.id.searchVideo)
//        videoView = view?.findViewById(R.id.videoView)!!

        val packageName = requireContext().packageName
         list = mutableListOf<searchData>(
            searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video2,"singh"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video5,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video6,"satwinder"),
            searchData("android.resource://" + packageName + "/" + R.raw.video7,"singh"),
            searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video2,"singh"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video5,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video6,"satwinder"),
            searchData("android.resource://" + packageName + "/" + R.raw.video7,"singh"),searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video2,"singh"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video5,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video6,"satwinder"),
            searchData("android.resource://" + packageName + "/" + R.raw.video7,"singh"),searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video2,"singh"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video5,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video6,"satwinder"),
            searchData("android.resource://" + packageName + "/" + R.raw.video7,"singh"),searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video2,"singh"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video5,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video6,"satwinder"),
            searchData("android.resource://" + packageName + "/" + R.raw.video7,"singh"),
        )
        val adapter = RecyclerAdapter4(requireContext(),list,this)
        val recycler :RecyclerView = view.findViewById(R.id.searchRecycler)
        recycler.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }
    var a = true

    override fun onClickStory(position: Int,view: VideoView) {
        if (view.isPlaying) {
            view.pause()
        } else {
            view.start()
        }

    }
}