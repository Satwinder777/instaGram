package com.example.mymusic.`interface`

import com.example.mymusic.dataClass.ProfileImage
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.dataClass.UnsplaceapiItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface uspInterface {

 @GET("/photos/?client_id=LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU")
 fun getImage():Call<Unsplaceapi>

 @POST("/collections/?client_id=LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU")
 fun postComment(@Body profileimg:ProfileImage):Call<UnsplaceapiItem>
}

//https://api.unsplash.com/collections?client_id=LaouBQbk85ic-A8o4rA_XDSUCUfoaHxiCECxd5ZDyUU