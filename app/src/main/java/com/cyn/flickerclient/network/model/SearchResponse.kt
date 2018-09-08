package com.cyn.flickerclient.network.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(var page: Int, @SerializedName("photo") var photos: List<Photo>)

data class Feed(var photos: SearchResponse)

data class Photo(var id: String, var title: String, var farm: String, var server: String, var secret: String) {
    fun getUrl(size: String) : String {
        return "https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + "_" + size + ".jpg"
    }
}