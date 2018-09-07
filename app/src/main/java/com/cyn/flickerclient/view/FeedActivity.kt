package com.cyn.flickerclient.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cyn.flickerclient.R
import com.cyn.flickerclient.network.model.SearchResponse
import com.cyn.flickerclient.viewmodel.RecentPostsViewModel

class FeedActivity : AppCompatActivity() {
    private lateinit var recentPostsViewModel: RecentPostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        if(savedInstanceState == null) {

        }
        recentPostsViewModel = ViewModelProviders.of(this).get(RecentPostsViewModel::class.java)

    }
}
