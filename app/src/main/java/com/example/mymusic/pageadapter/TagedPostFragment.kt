package com.example.mymusic.pageadapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymusic.PreviewActivity
import com.example.mymusic.R
import com.example.mymusic.dataClass.finalUri
import com.example.mymusic.dataClass.image
import com.example.mymusic.dataClass.videoUri
import com.example.mymusic.databinding.FragmentTagedPostBinding

class TagedPostFragment : Fragment(), UserPostAdapter.onclickitem {

    private lateinit var binding :FragmentTagedPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTagedPostBinding.inflate(layoutInflater)
        return binding.root

    }

     @SuppressLint("NotifyDataSetChanged")
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)

         var packageName = this
         var vidDAta = mutableListOf<String>("android.resource://" + packageName + "/" + R.raw.vid1,"android.resource://" + packageName + "/" + R.raw.video1,"android.resource://" + packageName + "/" + R.raw.video2)
         var uri2 = Uri.parse(vidDAta[2])
         var uri1 = Uri.parse(vidDAta[1])
         var uri0 = Uri.parse(vidDAta[0])
         var storyDAta = mutableListOf(image(R.drawable.img1),finalUri(uri0),image(R.drawable.img2),finalUri(uri1),image(R.drawable.img3),finalUri(uri2),image(R.drawable.img4),image(R.drawable.img2),)

         var rc = binding.taggeditemUserfragment
         var adapter = UserTaggedPostAdapter(storyDAta,this)
         rc.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
         rc.adapter = adapter
         adapter.notifyDataSetChanged()
     }

    override fun onPostClick(position: Int, view: View) {
        val intent = Intent(requireContext(),PreviewActivity::class.java)
//        intent.putExtra("listExtra",ArrayList(list) )
        startActivity(intent)

    }
}