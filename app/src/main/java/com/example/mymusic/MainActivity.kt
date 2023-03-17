package com.example.mymusic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout.HORIZONTAL
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.adapter.RecyclerAdapter
import com.example.mymusic.adapter.RecyclerAdapter2
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusicobject.Helper
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val AccessKey = "LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU"
 const val SecretKey = "wA5_P1ZoG0YCm3VLSlyruyR4XJQaiMH05MqavczqdGM"
class MainActivity : AppCompatActivity() {

    lateinit var list : MutableList<Unsplaceapi>
    lateinit var list2 : MutableList<Unsplaceapi>
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv2)


        recyclerView2 = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        list = mutableListOf()
        list2 = mutableListOf()
        var adapter = RecyclerAdapter(this,list)
        var adapter2 = RecyclerAdapter2(this,list2)
//        recyclerView.adapter = adapter
//        recyclerView2.adapter = adapter2
//        var view = layoutInflater.inflate(R.layout.album_rv_item,recyclerView,false)
//        recyclerView.addView(view)



        var request = Helper.getResp()
        var interface1 = request.create(uspInterface::class.java)
        interface1.getImage()
        var call:Call<Unsplaceapi> = interface1.getImage()
//        val call: Call<QuoteList> = quotesApi.getQuote()

        call.enqueue(object:Callback<Unsplaceapi>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Unsplaceapi>, response: Response<Unsplaceapi>) {
                if (response.isSuccessful){


//                    list.add(response.)

                    for ( result in 1..response.body()?.size!!){
                        list.add(response.body()!!)
                        list2.add(response.body()!!)
                    }
                    Log.e("resp", "onResponse: ${response.body()}", )
                }
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                adapter2.notifyDataSetChanged()
                recyclerView2.adapter = adapter2
            }

            override fun onFailure(call: Call<Unsplaceapi>, t: Throwable) {
                Toast.makeText(applicationContext, "failure", Toast.LENGTH_SHORT).show()
            }

        })

    }
}