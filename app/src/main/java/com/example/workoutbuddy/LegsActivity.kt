package com.example.workoutbuddy

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_arms.*

class LegsActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun backGroundColor() {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.setBackgroundDrawableResource(R.drawable.rect2)
        }
        setContentView(R.layout.activity_legs)
        //DISPLAY_HOME_AS_UP
        //backGroundColor()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        val bicepCurls = findViewById<CardView>(R.id.cardViewnib)
//        bicepCurls.setOnClickListener{
//            val intent = Intent(this@LegsActivity,Onexerciseclick::class.java)
//            startActivity(intent)
//
//
//        }



        val arrayList = ArrayList<Model>()
        arrayList.add(Model("DUMBBELL BICEPS","2 MINUTES",R.drawable.seven,R.drawable.rect9, Color.parseColor("#ff1717"), Color.parseColor("#80FF1717")))
        arrayList.add(Model("STRETCHING","5 MINUTES",R.drawable.four,R.drawable.rect9, Color.parseColor("#ff1717"), Color.parseColor("#80FF1717")))
        arrayList.add(Model("PUSH UPS","6 MINUTES",R.drawable.one,R.drawable.rect9, Color.parseColor("#ff1717"), Color.parseColor("#80FF1717")))
        arrayList.add(Model("SHOULDER PRESS","3 MINUTES",R.drawable.thirt,R.drawable.rect9, Color.parseColor("#ff1717"), Color.parseColor("#80FF1717")))
        arrayList.add(Model("VERTICAL LEG CRUNCHES","2 MINUTES",R.drawable.five,R.drawable.rect9, Color.parseColor("#ff1717"), Color.parseColor("#80FF1717")))
        val modelAdapter = ModelAdapter(arrayList,this) // this means that the this all things should be implemented here
        recyclerView.layoutManager = LinearLayoutManager(this) // here the view is attached to recycler view that means this should be implemented inside the recycler view
        recyclerView.adapter = modelAdapter

    }

//    override fun onNavigateUp(): Boolean {
//        onBackPressed()
//        finish()
//        return true
//
//    }


}


