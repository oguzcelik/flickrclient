package com.cyn.flickerclient.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.cyn.flickerclient.network.model.SearchResponse
import com.cyn.flickerclient.network.repository.FlickrRepository

class RecentPostsViewModel(application: Application) : AndroidViewModel(application) {
    var recentPostsObservable: LiveData<SearchResponse>

    init {
        recentPostsObservable = FlickrRepository.instance.getRecentPosts()
    }



}