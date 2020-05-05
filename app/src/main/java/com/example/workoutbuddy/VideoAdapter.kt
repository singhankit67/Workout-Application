package com.example.workoutbuddy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView

import androidx.recyclerview.widget.RecyclerView

class VideoAdapter:RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    internal lateinit var youtubeVideoList:List<YoutubeVideo>


    constructor() {}
    constructor(youtubeVideoList:List<YoutubeVideo>) {
        this.youtubeVideoList = youtubeVideoList
    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):VideoViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.onexerciseclick, parent, false)
        return VideoViewHolder(view)
    }
    override fun onBindViewHolder(holder:VideoViewHolder, position:Int) {
        holder.videoWeb.loadData(youtubeVideoList.get(position).videoUrl, "text/html", "utf-8")
    }
    inner class VideoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        internal var videoWeb:WebView
        init{
            videoWeb = itemView.findViewById(R.id.webView) as WebView
            videoWeb.getSettings().setJavaScriptEnabled(true)
            videoWeb.setWebChromeClient(object:WebChromeClient() {
            })
        }
    }

    override fun getItemCount(): Int {
        return youtubeVideoList.size
    }
}