package com.example.mymusic.pageadapter




import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.dataClass.videoUri

class UserReelAdapter(var context :Context, var list: MutableList<videoUri>,var onclickitem1: UserPostAdapter.onclickitem):RecyclerView.Adapter<UserReelAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reel_item,parent,false)
//        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item,parent,false)
//        InerClass()
        return  InerClass(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        val videoUri = Uri.parse(list[position].stringUri)
//        holder.videoView.start()
       holder.apply {
           itemView.setOnClickListener {
               onclickitem1.onPostClick(position, it )
           }
           reelItem.setVideoURI(videoUri)
       }

    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var reelItem = ItemView.findViewById<VideoView>(R.id.reelItem)
    }

}