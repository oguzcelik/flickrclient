package com.cyn.flickerclient.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cyn.flickerclient.R
import com.cyn.flickerclient.network.model.Photo
import com.cyn.flickerclient.network.model.SearchResponse
import com.cyn.flickerclient.view.util.CircularTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_feed.view.*

class FeedRecyclerViewAdapter(var items : List<Photo> = ArrayList()) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        Picasso.get().load(items[pos].url_z).into(holder.photo)
        Picasso.get().load(items[pos].getIconUrl()).placeholder(R.drawable.buddyicon)
                .transform(CircularTransform()).into(holder.profileImage)
        holder.name.text = items[pos].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setPhotos(photos: SearchResponse?) {
        items = photos?.photos ?: emptyList()
        notifyDataSetChanged()
    }

}

class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val profileImage = view.list_item_profile_picture
    val photo = view.list_item_photo
    val name = view.list_item_name
}