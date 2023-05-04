package com.example.mymusic.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.dataClass.postImage
import com.example.mymusic.dataClass.postVideo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostingDataAdapter(private val list: List<Any>,var context: Context,var onClikItempost1:onClikItempost):RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    var VIEW_TYPE_IMAGE = 0
    var VIEW_TYPE_VIDEO = 1
    var TAG ="test20"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

   when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
                return InerClass(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.reel_item,parent,false)
                return InerClass2(view)
            }
            else -> {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                return null!!
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        var item = list[position]
        return when (item) {
            is postImage -> VIEW_TYPE_IMAGE
            is postVideo -> VIEW_TYPE_VIDEO
            else -> throw IllegalArgumentException("Invalid view type")
        }

        }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = list[position]



        CoroutineScope(Dispatchers.Unconfined).launch {
            when (holder) {
                is InerClass -> {
                    var image = item as postImage
                    holder.bindView(image)
                    var imageUri  = Uri.parse(item.img)
                    holder.apply {
                        itemView.setOnClickListener {

                            onClikItempost1.onClick(imageUri,position)

                        }
                    }

                }
                is InerClass2-> {
                    var video = item as postVideo
                    holder.bindView2(video)
                    holder.apply {
                        itemView.setOnClickListener {
                            var videoUri  = Uri.parse(item.vid)
                            onClikItempost1.onClick(videoUri,position)

                        }
                    }
                }
                else->{
                    Log.e(TAG, "onBindViewHolder: null item", )}
            }

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var img = ItemView.findViewById<ImageView>(R.id.postItem)


        fun bindView(first: postImage){
            CoroutineScope(Dispatchers.Unconfined).launch {
                var string = first.img
                var uri = Uri.parse(string)
                img.setImageURI(uri)
            }
    }

    }
    class InerClass2(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var videoItem = ItemView.findViewById<VideoView>(R.id.reelItem)

        fun bindView2(second: postVideo){
            CoroutineScope(Dispatchers.Unconfined).launch {

                var string = second.vid
                var uri = Uri.parse(string)
                videoItem.setVideoURI(uri)
            }
        }
    }

    interface OnShareClick{
        fun onClickShare(position: Int)
    }

    interface onClikItempost{
        fun onClick(uri: Uri, position: Int)
        fun imageUri(uri: Uri, position: Int)

    }
}
