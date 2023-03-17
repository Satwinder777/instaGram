package com.example.mymusic.`interface`

import com.example.mymusic.dataClass.Unsplaceapi
import retrofit2.Call
import retrofit2.http.GET

interface uspInterface {

 @GET("/photos/?client_id=LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU")
 fun getImage():Call<Unsplaceapi>
}