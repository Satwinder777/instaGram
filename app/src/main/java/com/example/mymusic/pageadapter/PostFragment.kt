package com.example.mymusic.pageadapter

import android.annotation.SuppressLint
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

class PostFragment : Fragment(),
    UserPostAdapter.onclickitem {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post2, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = mutableListOf<Int>(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img1,R.drawable.img3,R.drawable.img4,)
        val adapter = UserPostAdapter(requireContext(),list,this)
        val recycler : RecyclerView = view.findViewById(R.id.tabLayoutPostREcycler)
        recycler.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }

//    override fun onPostClick(position: Int, view: View, list: MutableList<videoUri>) {
//
////        Toast.makeText(requireContext(), "working...", Toast.LENGTH_SHORT).show()
//
//    }

    override fun onPostClick(position: Int, view: View) {
        val intent = Intent(requireContext(),PreviewActivity::class.java)
        startActivity(intent)
    }


}