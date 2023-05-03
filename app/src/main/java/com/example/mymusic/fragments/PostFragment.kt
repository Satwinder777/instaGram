package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.adapter.PostingDataAdapter
import com.example.mymusic.dataClass.postImage
import com.example.mymusic.dataClass.postVideo
import com.example.mymusic.databinding.FragmentPostBinding


class PostFragment : Fragment(),PostingDataAdapter.onClikItempost {
    private lateinit var binding :FragmentPostBinding
    private lateinit var adapter : PostingDataAdapter
    private lateinit var recycler : RecyclerView
    private lateinit var list: MutableList<Any>
    private lateinit var imageView :ImageView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(layoutInflater)
        return binding.root
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        staticDataAdded()
            adapter = PostingDataAdapter(list,requireContext(),this)
            recycler = binding.postRecycler1

            recycler.adapter = adapter
        imageView = binding.postingImage





        adapter.notifyDataSetChanged()







    }
private fun staticDataAdded(){


    var uri1 ="android.resource://${context?.packageName}/" + R.drawable.img1
    var uri2 ="android.resource://${context?.packageName}/" + R.raw.vid1

    var uri3 ="android.resource://${context?.packageName}/" + R.drawable.img2
    var uri4 ="android.resource://${context?.packageName}/" + R.raw.vid2

    var uri5 ="android.resource://${context?.packageName}/" + R.drawable.img3
    var uri6 ="android.resource://${context?.packageName}/" + R.raw.vid3

    var uri7 ="android.resource://${context?.packageName}/" + R.drawable.img4
    var uri8 ="android.resource://${context?.packageName}/" + R.raw.vid4
    list = mutableListOf(postImage(uri1),postVideo(uri2),postImage(uri3),postVideo(uri4)
        ,postImage(uri5),postVideo(uri6),postImage(uri7),postVideo(uri8),)

}

    override fun onClick(uri: Uri, position: Int) {

        var item = list[position]
        when(item){
            is postVideo ->{
                binding.postingVideo.visibility = View.VISIBLE
                binding.postingImage.visibility = View.GONE
                var video = binding.postingVideo1
//                video.setVideoURI(uri)
                playVideo(binding.postingVideo1,uri)

            }

            is postImage->{
                binding.postingVideo.visibility = View.GONE
                binding.postingImage.visibility = View.VISIBLE
                var video = binding.postingVideo
                imageView.setImageURI(uri)
            }
        }
//        Log.e("test20", "onClick: $uri", )
    }

    override fun imageUri(uri: Uri, position: Int) {

//                if (imageView.visibility == View.GONE) {
//
//                    binding.postingVideo.visibility = View.GONE
//                    imageView.visibility = View.VISIBLE
////                Picasso.get()
////                    .load(uri)
////                    .into(binding.postingImage)
////                binding.postingImage.setImageURI(uri)
//
//                    Log.e("test20", "imageUri: $list[position]",)
//                }
            }
    private fun playVideo(video:VideoView,uri: Uri){
        video.setVideoURI(uri)
        video.setOnClickListener {
            if (video.isPlaying.not()){

                video.start()
            }
            else{
                video.pause()
            }
        }

    }

        }
