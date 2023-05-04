package com.example.mymusic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.adapter.RecyclerAdapter2
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusic.pageadapter.PreviewPostAdapter
import com.example.mymusicobject.Helper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreviewActivity : AppCompatActivity(),PreviewPostAdapter.OnClickBottom {
    lateinit var list2 : MutableList<Unsplaceapi>
    lateinit var rv : RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
//        val previewDAtaList = intent.getSerializableExtra("listExtra") as ArrayList<*>?
        list2 = mutableListOf()

        var adapter = PreviewPostAdapter(this,list2 ,this)
        rv = findViewById<RecyclerView>(R.id.previewRecyclerView)
        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.adapter = adapter
        var request = Helper.getResp()
        var interface1 = request.create(uspInterface::class.java)
        interface1.getImage()
        var call: Call<Unsplaceapi> = interface1.getImage()
//        val call: Call<QuoteList> = quotesApi.getQuote()
//        gdegdege
        call.enqueue(object: Callback<Unsplaceapi> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Unsplaceapi>, response: Response<Unsplaceapi>) {
                if (response.isSuccessful){


//                    list.add(response.)
//                    progressBar.visibility = View.INVISIBLE

                    for ( result in 1..response.body()?.size!!){
//                        list.add(response.body()!!)
                        list2.add(response.body()!!)
                    }
                    Log.e("resp", "onResponse: ${response.body()}", )
                }
//                adapter.notifyDataSetChanged()
//                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
                rv.adapter = adapter
            }

            override fun onFailure(call: Call<Unsplaceapi>, t: Throwable) {
                Toast.makeText(this@PreviewActivity, "failure", Toast.LENGTH_SHORT).show()
            }

        })

        var backbtn = findViewById<ImageView>(R.id.backbtnPreviewActivity)
        backbtn.setOnClickListener { onBackPressed() }
    }

    override fun onClickBottomSheet(unsplaceapi: Unsplaceapi) {
        Toast.makeText(this, "on working", Toast.LENGTH_SHORT).show()
    }
}