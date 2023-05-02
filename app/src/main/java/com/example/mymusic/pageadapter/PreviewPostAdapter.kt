package com.example.mymusic.pageadapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.CommentActivity
import com.example.mymusic.R
import com.example.mymusic.dataClass.Unsplaceapi
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso

class PreviewPostAdapter(var context :Context, var list: MutableList<Unsplaceapi>,var onClickBottom:OnClickBottom):RecyclerView.Adapter<PreviewPostAdapter.InerClass>() {

    var view1 = LayoutInflater.from(context).inflate(R.layout.bottomsheet,null)
    @SuppressLint("InflateParams")
//var view2 = LayoutInflater.from(context).inflate(R.layout.activity_share,null)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item2,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: InerClass, position: Int) {
        var clickc = 0
        var isLiked = false
        val bottomSheetDialog = BottomSheetDialog(context)
        holder.apply {
            itemView.setOnClickListener { bottomSheetDialog.dismiss() }
            bindView(list[position])
            var a: Boolean = true
            var b = likeadd

            likebtn.setOnClickListener {
                if (a == false ) {
                    likebtn.setImageResource(R.drawable.baseline_favorite_border_24)
                    b--
                    like.text = b.toString().plus(" Likes")

                    clickc=0
                    a = true
                } else {
                    likebtn.setImageResource(R.drawable.baseline_favorite_24)
                    b++
                    like.text = b.toString().plus(" Likes")
                    a = false
                }
            }
            commentbtn.setOnClickListener {
                val intent = Intent(context, CommentActivity::class.java)
                context.startActivity(intent)
            }
            moremenu.setOnClickListener {
//                val view = layoutInflater.inflate(R.layout.bottomsheet, null)
                bottomSheetDialog.setContentView(view1)
                bottomSheetDialog.show()
            }
            sharebtn.setOnClickListener {
                onClickBottom.onClickBottomSheet(list[position])
            }
            postImage.setOnClickListener {
                clickc++
                if (clickc==2){
                    likebtn.setImageResource(R.drawable.baseline_favorite_24)
                    b++
                    like.text = b.toString().plus(" Likes")
                    a = false

                    isLiked =true
                }
            }


        }


    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var img = ItemView.findViewById<ImageView>(R.id.songCoverImg)
        var text2 = ItemView.findViewById<TextView>(R.id.titleInsta)
        var text1 = ItemView.findViewById<TextView>(R.id.captionInsta)
        var likebtn = ItemView.findViewById<ImageView>(R.id.like)
        var commentbtn = ItemView.findViewById<ImageView>(R.id.comment)
        var sharebtn = ItemView.findViewById<ImageView>(R.id.share)
        var userName = ItemView.findViewById<TextView>(R.id.postUsername)
        var like = ItemView.findViewById<TextView>(R.id.main_like_count)
        var mediaNAme = ItemView.findViewById<TextView>(R.id.postmedia)
        var userImage = ItemView.findViewById<ImageView>(R.id.userImgpost)
        var moremenu = ItemView.findViewById<ImageView>(R.id.more)
        var likeadd = 0

        var postImage = ItemView.findViewById<ImageView>(R.id.songCoverImg)

        fun bindView(unsplaceapi: Unsplaceapi){
            var url:String = unsplaceapi[position].urls.small
            Picasso.get()
                .load(url)
                .into(img)
//            img.setImageResource(list[postImage] as Int)
            likeadd = unsplaceapi[adapterPosition].likes


            text1.text = unsplaceapi[position].user.bio
            text2.text = unsplaceapi[position].user.name
            userName.text = unsplaceapi[position].user.username
            mediaNAme.text = unsplaceapi[position].user.location
            like.text = unsplaceapi[adapterPosition].likes.toString().plus(" likes")
            Picasso.get()
                .load(url)
                .into(userImage)

            if (unsplaceapi[position].user.instagram_username.isNullOrEmpty()){
                text1.text = "satwinder_SherGill"
            }
            if (unsplaceapi[adapterPosition].user.bio.isNullOrEmpty()){
                text2.text = "the quick brown fox jumps over the lazy dog"
            }
            if(unsplaceapi[position].user.location.isNullOrEmpty()){
                mediaNAme.text = "Ambarsaria"
            }



        }
    }

    interface OnClickBottom{
        fun onClickBottomSheet(unsplaceapi: Unsplaceapi)

    }
}