package com.cyn.flickerclient.network.repository

import com.cyn.flickerclient.network.model.Feed
import com.cyn.flickerclient.network.model.PersonInfoResponse
import com.cyn.flickerclient.network.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {

    @GET("rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1&per_page=20")
    fun getLatestPhotos(@Query("api_key") apiKey: String): Call<Feed>

    @GET("/services/rest/?method=flickr.people.getInfo&format=json&nojsoncallback=")
    fun getPersonInfo(@Query("api_key") apiKey: String
                      , @Query("user_id") userId: String) : Call<PersonInfoResponse>

}