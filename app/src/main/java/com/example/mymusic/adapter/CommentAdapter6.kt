package com.example.mymusic.adapter

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mymusic.R
import com.example.mymusic.dataClass.Unsplaceapi
import com.squareup.picasso.Picasso

class CommentAdapter6(var list: MutableList<Unsplaceapi>):RecyclerView.Adapter<CommentAdapter6.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item3,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.apply {
            bindView(list[position])
//            var like:Boolean = false


        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var UserImg = ItemView.findViewById<ImageView>(R.id.UsernameImg)
        var userNameText = ItemView.findViewById<TextView>(R.id.usernameId)
        var commentText = ItemView.findViewById<TextView>(R.id.item_comment)
        var replyText = ItemView.findViewById<TextView>(R.id.item_reply)
        var commentLikebtn = ItemView.findViewById<ImageView>(R.id.comment_item_like)
        var likeCount = ItemView.findViewById<TextView>(R.id.like_count)

        fun bindView(unsplaceapi: Unsplaceapi){


            var url:String = unsplaceapi[position].urls.small
            Picasso.get()
                .load(url)
                .into(UserImg)


            userNameText.text = unsplaceapi[position].user.instagram_username
            commentText.text = unsplaceapi[position].user.bio
            var like:Boolean = false

            var a  = unsplaceapi[adapterPosition].likes
            commentLikebtn.setOnClickListener {
                if (like==false){
                    commentLikebtn.setImageResource(R.drawable.baseline_favorite_24)

                    like=true
                    a++
                    likeCount.text = a.toString()

                }
                else{
                    commentLikebtn.setImageResource(R.drawable.baseline_favorite_border_24)

                    like=false
                    a--
                    likeCount.text = a.toString()

                }
            }
            likeCount.text = unsplaceapi[adapterPosition].likes.toString()
            if (unsplaceapi[position].user.instagram_username.isNullOrEmpty()){
                userNameText.text = "satwinder_SherGill"
            }
           if (unsplaceapi[adapterPosition].user.bio.isNullOrEmpty()){
                commentText.text = "the quick brown fox jumps over the lazy dog"
            }

        }
    }
//    interface postComment{
//        fun commentposted()
//    }
}