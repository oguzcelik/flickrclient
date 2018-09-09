package com.cyn.flickerclient.network.repository

import com.cyn.flickerclient.network.model.Feed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {

    @GET("rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1&per_page=20&extras=url_z,owner_name,description,icon_server")
    fun getLatestPhotos(@Query("api_key") apiKey: String): Call<Feed>
}