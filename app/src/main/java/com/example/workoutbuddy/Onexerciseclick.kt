package com.example.workoutbuddy

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.row_cardview.*
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_onexerciseclick.*
import kotlinx.android.synthetic.main.activity_onexerciseclick.view.*
import java.util.*

class Onexerciseclick : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var youtubeVideos = Vector<YoutubeVideo>()
    var holder:ModelAdapter.ViewHolder? = null
    val arrayList = ArrayList<Model>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun backGroundColor() {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.setBackgroundDrawableResource(R.drawable.rect2)
        }
        setContentView(R.layout.activity_onexerciseclick)
        //backGroundColor()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        youtubeVideos.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ykJmrZ5v0Oo\" frameborder=\"0\" allowfullscreen></iframe>"))
        val videoAdapter = VideoAdapter(youtubeVideos)
        recyclerView.adapter = videoAdapter
        //now we get the data from putExtra
        val intent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aTime = intent.getStringExtra("iTime")
        val aTitleColor = intent.getIntExtra("iTitleColor",0)
        val aTimeColor = intent.getIntExtra("iTimeColor",0)
        mainHead2.text = aTitle
        mainHead2.setTextColor(aTitleColor)
        subHead2.text = aTime
        subHead2.setTextColor(aTimeColor)
    }
}
