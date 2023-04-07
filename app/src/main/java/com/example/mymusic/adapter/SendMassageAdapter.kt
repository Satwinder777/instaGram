package com.example.mymusic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.R
import com.example.mymusic.dataClass.sendMassage

class SendMassageAdapter(var list: List<sendMassage>):RecyclerView.Adapter<SendMassageAdapter.InnerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item6,parent,false)
        return InnerClass(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InnerClass, position: Int) {
        holder.msg.text = list[position].msg
    }
    class InnerClass(view:View):RecyclerView.ViewHolder(view) {
        var msg = view.findViewById<TextView>(R.id.sendtxt)

    }
}