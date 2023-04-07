package com.example.mymusic.adapter

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mymusic.R
import com.example.mymusic.dataClass.Unsplaceapi
import com.squareup.picasso.Picasso

class RecyclerAdapter(var context :Context,var list: MutableList<Unsplaceapi>,var onClickStoryBtn: RecyclerAdapter.OnStoryClick):RecyclerView.Adapter<RecyclerAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item,parent,false)
//        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item,parent,false)
//        InerClass()
        return  InerClass(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.apply {
            bindView(list[position])
            itemView.setOnClickListener {
                onClickStoryBtn.onClickStory(position)
//                sharebtn.setText("Undo")
                            }
        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var img = ItemView.findViewById<ImageView>(R.id.songCoverImg)
        var text1 = ItemView.findViewById<TextView>(R.id.songName)


        fun bindView(unsplaceapi: Unsplaceapi){
            var url:String = unsplaceapi[position].urls.small
            Picasso.get()
                .load(url)
                .into(img)


            text1.text = unsplaceapi[position].user.instagram_username
            if (unsplaceapi[position].user.instagram_username.isNullOrEmpty()){
                text1.text = "satwinder_SherGill"
            }



        }
    }
    interface OnStoryClick{
        fun onClickStory(position: Int)
    }
}