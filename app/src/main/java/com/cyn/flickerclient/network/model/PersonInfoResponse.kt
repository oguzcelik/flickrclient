package com.cyn.flickerclient.network.model

data class PersonInfoResponse(var id: String,var realName: String, var iconFarm: String, var iconServer: String) {
    fun getIconUrl(): String {
        if(iconServer.toInt() > 0) {
            return "http://farm"+ iconFarm +".staticflickr.com/"+ iconServer + "/buddyicons/" + id + ".jpg"
        } else {
            return "https://www.flickr.com/images/buddyicon.gif"
        }
    }
}