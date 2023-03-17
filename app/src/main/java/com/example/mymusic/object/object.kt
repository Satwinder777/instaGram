package com.example.mymusicobject;

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val newurl = "https://api.unsplash.com"
        object Helper {


            val base_url = "/photos/?client_id=LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU"
            val base_url1 = "https://api.unsplash.com"

            fun getResp() :Retrofit {
                var inst = Retrofit.Builder().baseUrl(base_url1)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                return inst
            }

        }





//import android.annotation.SuppressLint
//import com.example.retrofitdemo.Result
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//const val url = "https://quotable.io/quotes?page=1"
//        object RetrofitHelper{
//
//        val baseUrl = "https://quotable.io/"
//
//@SuppressLint("SuspiciousIndentation")
//    fun getInstance() : Retrofit{
//            var instance = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
//            return instance
//            }
//            }