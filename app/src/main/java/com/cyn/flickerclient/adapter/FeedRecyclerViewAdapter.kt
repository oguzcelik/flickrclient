package com.cyn.flickerclient.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cyn.flickerclient.R
import com.cyn.flickerclient.network.model.Photo
import com.cyn.flickerclient.network.model.SearchResponse
import com.cyn.flickerclient.util.CircularTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_feed.view.*

class FeedRecyclerViewAdapter(var items : List<Photo> = ArrayList()) : RecyclerView.Adapter<FeedRecyclerViewAdapter.ViewHolder>() {
    interface OnItemPreviewListener {
        fun onItemPreview(item: Photo)
    }

    lateinit var onItemPreviewListener: OnItemPreviewListener

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(items[pos])
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
    inner class ViewHolder (view : View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        override fun onClick(v: View?) {
            onItemPreviewListener.onItemPreview(items[adapterPosition])
        }

        fun bind(item: Photo) {
            Picasso.get().load(item.url_z).into(photo)
            Picasso.get().load(item.getIconUrl()).placeholder(R.drawable.buddyicon)
                    .transform(CircularTransform()).into(profileImage)
            name.text = item.name
            itemView.setOnClickListener(this)
        }

        val profileImage = view.list_item_profile_picture
        val photo = view.list_item_photo
        val name = view.list_item_name
    }
}

