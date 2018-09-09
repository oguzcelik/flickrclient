package com.cyn.flickerclient.network.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(var page: Int, @SerializedName("photo") var photos: List<Photo>)

data class Feed(var photos: SearchResponse)

data class Photo(var id: String
                 , var owner: String
                 , var title: String
                 , @SerializedName("iconfarm") var farm: String
                 , @SerializedName("iconserver") var server: String
                 , @SerializedName("ownername") var name: String
                 , var secret: String
                 , var url_z: String) {

    fun getIconUrl(): String {
        return "http://farm" + farm + ".staticflickr.com/" + server + "/buddyicons/" + owner + ".jpg"
    }

    fun getLargePhotoUrl(): String {
        return url_z.dropLast(5).plus("b.jpg")
    }

}