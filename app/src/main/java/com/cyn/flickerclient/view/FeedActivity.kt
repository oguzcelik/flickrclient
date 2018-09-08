package com.cyn.flickerclient.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.cyn.flickerclient.R
import com.cyn.flickerclient.adapter.FeedRecyclerViewAdapter
import com.cyn.flickerclient.network.model.SearchResponse
import com.cyn.flickerclient.viewmodel.RecentPostsViewModel
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {
    private lateinit var recentPostsViewModel: RecentPostsViewModel
    private lateinit var adapter : FeedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        recentPostsViewModel = ViewModelProviders.of(this).get(RecentPostsViewModel::class.java)
        feed_list.layoutManager = LinearLayoutManager(this)

        adapter = FeedRecyclerViewAdapter()
        feed_list.adapter = adapter

        observeViewModel(recentPostsViewModel)
    }

    private fun observeViewModel(viewModel: RecentPostsViewModel) {
        viewModel.recentPostsObservable.observe(this, Observer<SearchResponse> {
            adapter.setPhotos(it)
        })
    }


}
