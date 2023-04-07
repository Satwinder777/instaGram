package com.example.mymusic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.dataClass.Unsplaceapi
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso

class MassageAdapter(var context :Context, var list: MutableList<Unsplaceapi>, var onClickShareBtn:OnItemClick):RecyclerView.Adapter<MassageAdapter.InerClass>()  {

var view = LayoutInflater.from(context).inflate(R.layout.bottomsheet,null)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item5,parent,false)
        return  InerClass(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
//        val bottomSheetDialog = BottomSheetDialog(context)
//        bottomSheetDialog.dismiss()
        holder.apply {
            itemView.setOnClickListener {
                onClickShareBtn.onClickItem(position)
            }
            bindView(list[position])
            var like:Boolean = false


//
//            moremenu.setOnClickListener {
//
//
////                val view = layoutInflater.inflate(R.layout.bottomsheet, null)
//                bottomSheetDialog.setContentView(view)
//                bottomSheetDialog.show()
//
//            }
//            sharebtn.setOnClickListener {
//                onClickShareBtn.onClickShare(position)
//                sharebtn.setText("Undo")
//            }


        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var shareimg = ItemView.findViewById<ImageView>(R.id.shareUserimg)
        var textname = ItemView.findViewById<TextView>(R.id.sharename)
        var textUserName = ItemView.findViewById<TextView>(R.id.shareuserName)
//        var sharebtn = ItemView.findViewById<Button>(R.id.sharebtn)
        var btnsend = ItemView.findViewById<Button>(R.id.btn_send)


        fun bindView(unsplaceapi: Unsplaceapi){
            var url:String = unsplaceapi[position].urls.small
            Picasso.get()
                .load(url)
                .into(shareimg)

            textname.text = unsplaceapi[position].user.name
            textUserName.text = unsplaceapi[position].user.instagram_username

//            Picasso.get()
//                .load(url)
//                .into(userImage)

            if (unsplaceapi[position].user.instagram_username.isNullOrEmpty()){
                textUserName.text = "Sher_Gill"
            }
            if (unsplaceapi[position].user.name.isEmpty()){
                textname.text = "shergill_production"
            }
        }
    }

    interface OnItemClick{
        fun onClickItem(position: Int)
    }

}
