package com.example.workoutbuddy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class DaywiseMode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun backGroundColor() {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.setBackgroundDrawableResource(R.drawable.rect2)
        }
        setContentView(R.layout.activity_daywise_mode)
        //backGroundColor()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val backDay = findViewById(R.id.cardView2) as CardView
        backDay.setOnClickListener{
            val intent = Intent(this@DaywiseMode,BackActivity::class.java)
            startActivity(intent)

        }
        val shoulderDay = findViewById(R.id.cardView4) as CardView
        shoulderDay.setOnClickListener{
            val intent = Intent(this@DaywiseMode,ShoulderActivity::class.java)
            startActivity(intent)

        }
        val legsDay = findViewById(R.id.cardView) as CardView
        legsDay.setOnClickListener{
            val intent = Intent(this@DaywiseMode,LegsActivity::class.java)
            startActivity(intent)

        }
        val armsDay = findViewById(R.id.cardView5) as CardView
        armsDay.setOnClickListener{
            val intent = Intent(this@DaywiseMode,ArmsActivity::class.java)
            startActivity(intent)

        }
        val chestDay = findViewById(R.id.cardView1) as CardView
        chestDay.setOnClickListener{
            val intent = Intent(this@DaywiseMode,ChestActivity::class.java)
            startActivity(intent)

        }
    }

}
