package com.cyn.flickerclient.network.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.cyn.flickerclient.network.model.Feed
import com.cyn.flickerclient.network.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlickrRepository private constructor(): Callback<Feed> {
    val data: MutableLiveData<SearchResponse> = MutableLiveData()

    private object Holder { val INSTANCE = FlickrRepository() }

    companion object {
        val instance: FlickrRepository by lazy { Holder.INSTANCE }
        val API_KEY =  "ae5155d8f67aaf83479e37f0024fe53a"
        fun create(): FlickrApi {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.flickr.com/services/")
                    .build()

            return retrofit.create(FlickrApi::class.java)
        }
    }

    override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
        data.value = response.body()?.photos
    }

    override fun onFailure(call: Call<Feed>?, t: Throwable?) {
    }

    fun getRecentPosts(): LiveData<SearchResponse> {
        create().getLatestPhotos(API_KEY).enqueue(this)

        return data
    }

}