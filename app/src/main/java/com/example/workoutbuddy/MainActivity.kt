package com.example.workoutbuddy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun backGroundColor() {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.setBackgroundDrawableResource(R.drawable.rect2)
        }
        setContentView(R.layout.activity_main)
        //backGroundColor()
        random()
        dayWise()

        }
    fun random() {
        val randomSelect = findViewById<CardView>(R.id.cardViewb)
        randomSelect.setOnClickListener {
            val intent = Intent(this@MainActivity, RandomActivity::class.java)
            startActivity(intent)
        }
    }
        fun dayWise() {
            val daywiseSelect = findViewById<CardView>(R.id.cardView1b)
            daywiseSelect.setOnClickListener {
                val intent = Intent(this@MainActivity, DaywiseMode::class.java)
                startActivity(intent)

        }

    }
}
