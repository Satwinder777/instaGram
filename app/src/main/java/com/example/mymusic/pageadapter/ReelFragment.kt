package com.example.mymusic.pageadapter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymusic.PreviewActivity
import com.example.mymusic.R
import com.example.mymusic.dataClass.videoUri

class ReelFragment : Fragment(), UserPostAdapter.onclickitem {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reel2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var adapter = UserReelAdapter(requireContext(),uriHandled(),this)
        val recycler : RecyclerView = view.findViewById(R.id.reelRecyclerUSerFragment)
        recycler.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun uriHandled():MutableList<videoUri>{

        val list = mutableListOf<videoUri>(
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.video1)
            ,
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.video3),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.video4) ,
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.video5),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.video6),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.video7),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.vid1),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.vid2),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.vid3),
            videoUri("android.resource://" + requireContext().packageName + "/" + R.raw.vid4),
        )

return list
    }

    override fun onPostClick(position: Int, view: View) {
        val intent = Intent(requireContext(), PreviewActivity::class.java)
        startActivity(intent)
    }

}