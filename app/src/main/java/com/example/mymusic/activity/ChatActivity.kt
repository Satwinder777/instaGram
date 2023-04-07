package com.example.mymusic.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymusic.R
import com.example.mymusic.adapter.SendMassageAdapter
import com.example.mymusic.dataClass.sendMassage
import com.example.mymusic.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChatBinding
    private lateinit var list:MutableList<sendMassage>
    private lateinit var adapter:SendMassageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView12.setOnClickListener {
            onBackPressed()
        }
        list = mutableListOf<sendMassage>(sendMassage("hi Satwinder"),sendMassage("where Are "),sendMassage("you"),sendMassage("haa haa"),sendMassage("guess who i am "),)
         adapter = SendMassageAdapter(list)
        val rc =binding.msgrecycler
        rc.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        rc.adapter = adapter

        binding.sendmsg.setOnClickListener {
            sendmsg(binding.sendmsgEditor)
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun sendmsg(text:EditText){
        list.add(sendMassage("${text.text}"))
        adapter.notifyDataSetChanged()
    }
}