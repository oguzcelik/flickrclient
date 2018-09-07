package com.cyn.flickerclient.network.repository

import com.cyn.flickerclient.network.model.PhotoInfoResponse
import com.cyn.flickerclient.network.model.SearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {

    @GET("/services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    fun getLatestPhotos(@Query("api_key") apiKey: String
                        , @Query("tags") tags: String): Call<SearchResponse>

    @GET("/services/rest/?method=flickr.photos.getInfo&format=json&nojsoncallback=1")
    fun getPhotoInfo(@Query("api_key") apiKey: String
                     , @Query("photo_id") photoId: String): Call<PhotoInfoResponse>

}