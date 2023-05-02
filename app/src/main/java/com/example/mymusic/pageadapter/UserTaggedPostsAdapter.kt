package com.example.mymusic.pageadapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.dataClass.finalUri
import com.example.mymusic.dataClass.image


class UserTaggedPostAdapter(var list: MutableList<Any>,var onclickitem1: UserPostAdapter.onclickitem):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_IMAGE = 0
        const val VIEW_TYPE_VIDEO = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            VIEW_TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
                InerClass(view)
            }
            VIEW_TYPE_VIDEO -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.reel_item, parent, false)
                VideoViewHolder(view)

            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        passData1?.changePosition(position)
//        holder.apply {
//            itemView.setOnClickListener {
//                passData1?.changePosition(position)
//            }
//        }
holder.apply { itemView.setOnClickListener {
    onclickitem1.onPostClick(position, it)
} }

        val item = list[position]

        when (holder) {
            is InerClass -> {
                val image = item as image
                (holder).bind(image)

//                passData1?.imageDAta(image)
            }
            is VideoViewHolder -> {

                val video = item as finalUri
                (holder).bind(video)
//                passData1?.videoDAta(video)
            }
            else ->{
                throw IllegalArgumentException("Errorr Occur binding")
            }
        }
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size


    }

    @SuppressLint("SuspiciousIndentation")
    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        Log.e("test", "getItemViewType:  $list ", )

        return when (list[position]) {
            is image  -> VIEW_TYPE_IMAGE
            is finalUri -> VIEW_TYPE_VIDEO
            else ->  throw IllegalArgumentException("got error")



        }




    }

    class VideoViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var TAG = "test123"




        fun bind(uri: finalUri) {
            VideoItem.setVideoURI(uri.uri)
            VideoItem.setOnErrorListener { mp, what, extra ->
                Log.e(TAG, "bind: Error in VideoViewHolder ", )
                true
            }
        }
        val VideoItem: VideoView = itemView.findViewById(R.id.reelItem)
    }
    class InerClass(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var childImage = ItemView.findViewById<ImageView>(R.id.postItem)

        fun bind(img: image) {
            childImage.setImageResource(img.img)
        }
    }





}
