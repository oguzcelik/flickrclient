package com.cyn.flickerclient.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cyn.flickerclient.R
import com.cyn.flickerclient.network.model.PhotoInfoResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_feed.view.*

class FeedRecyclerViewAdapter(val items : ArrayList<PhotoInfoResponse>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.name.text = "Oğuz"
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val profileImage = view.list_item_profile_picture
    val photo = view.list_item_photo
    val name = view.list_item_name
}