package com.cyn.flickerclient.view

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.cyn.flickerclient.R
import com.cyn.flickerclient.viewmodel.RecentPostsViewModel
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {
    private lateinit var recentPostsViewModel: RecentPostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        recentPostsViewModel = ViewModelProviders.of(this).get(RecentPostsViewModel::class.java)
        feed_list.layoutManager = LinearLayoutManager(this)
    }
}
