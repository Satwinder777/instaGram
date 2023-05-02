package com.example.mymusic.adapter

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mymusic.R
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.dataClass.searchData
import com.squareup.picasso.Picasso

class RecyclerAdapter4(var context :Context, var list: MutableList<searchData>,var OnVideoClick:OnStoryClick):RecyclerView.Adapter<RecyclerAdapter4.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item8,parent,false)
//        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item,parent,false)
//        InerClass()
        return  InerClass(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        val videoUri = Uri.parse(list[position].video)
//        holder.videoView.start()
        holder.apply {
            holder.videoView.setVideoURI(videoUri)

            itemView.setOnClickListener {
                OnVideoClick.onClickStory(position,videoView)
            }

        }

    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var videoView = ItemView.findViewById<VideoView>(R.id.searchVideo)

    }
    interface OnStoryClick{
        fun onClickStory(position: Int,videoView: VideoView)
    }
}