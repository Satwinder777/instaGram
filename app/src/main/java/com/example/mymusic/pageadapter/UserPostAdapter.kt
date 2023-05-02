package com.example.mymusic.pageadapter




import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.dataClass.videoUri

class UserPostAdapter(var context :Context, var list: MutableList<Int> ,var onclickitem1:onclickitem):RecyclerView.Adapter<UserPostAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
//        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item,parent,false)
//        InerClass()
        return  InerClass(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {


//        holder.videoView.start()
       holder.apply {
           postItem.setImageResource(list[position])
           itemView.setOnClickListener {
               onclickitem1.onPostClick(position,it)
           }
       }

    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var postItem = ItemView.findViewById<ImageView>(R.id.postItem)
    }
    interface onclickitem {
        fun onPostClick(position: Int, view: View)
    }

}