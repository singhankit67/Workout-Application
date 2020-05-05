package com.example.workoutbuddy

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_arms.*
import kotlinx.android.synthetic.main.activity_arms.recyclerView
import kotlinx.android.synthetic.main.activity_random.*
import kotlinx.android.synthetic.main.row_cardview.*
import java.util.*
import kotlin.collections.ArrayList

class RandomActivity : AppCompatActivity(){
    val arrayList = ArrayList<Model>()
    var modelAdapter:ModelAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun backGroundColor() {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            window.setBackgroundDrawableResource(R.drawable.rect2)
        }
        setContentView(R.layout.activity_random)
        var list :MutableList<Model>? = null

        arrayList.add(Model("DUMBBELL BICEPS","2 MINUTES",R.drawable.seven,R.drawable.rect3, Color.parseColor("#ffffff"), Color.parseColor("#b3b3b3")))
        arrayList.add(Model("STRETCHING","5 MINUTES",R.drawable.four,R.drawable.rect3, Color.parseColor("#ffffff"), Color.parseColor("#b3b3b3")))
        arrayList.add(Model("PUSH UPS","6 MINUTES",R.drawable.one,R.drawable.rect3, Color.parseColor("#ffffff"), Color.parseColor("#b3b3b3")))
        arrayList.add(Model("SHOULDER PRESS","3 MINUTES",R.drawable.thirt,R.drawable.rect3, Color.parseColor("#ffffff"), Color.parseColor("#b3b3b3")))
        arrayList.add(Model("VERTICAL LEG CRUNCHES","2 MINUTES",R.drawable.five,R.drawable.rect3, Color.parseColor("#ffffff"), Color.parseColor("#b3b3b3")))
        modelAdapter = ModelAdapter(arrayList,this) // this means that the this all things should be implemented here
        recyclerView.layoutManager = LinearLayoutManager(this) // here the view is attached to recycler view that means this should be implemented inside the recycler view
        //      Create the ItemTouchHelper
        //this builds the item touch helper for us in which the views can be only moved up or down
        val callback: ItemTouchHelper.Callback = ItemMoveCallback(modelAdapter!!)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = modelAdapter
        //backGroundColor()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //set back button
        enableSwipeToDeleteAndUndo()
    }
    private fun enableSwipeToDeleteAndUndo() {
        val swipeToDeleteCallback = object:UIActionClass(this) {
            override fun onSwiped(@NonNull viewHolder:RecyclerView.ViewHolder, i:Int) {
                val position = viewHolder.adapterPosition
                val item = modelAdapter?.getData()?.get(position)
                modelAdapter?.removeItem(position)
                val snackbar = Snackbar
                    .make(cardViewnib, "Item was removed from the list.", Snackbar.LENGTH_LONG)
                snackbar.setAction("UNDO", object: View.OnClickListener {
                    override fun onClick(view:View) {
                        if (item != null) {
                            modelAdapter?.restoreItem(item, position)
                        }
                        recyclerView.scrollToPosition(position)
                    }
                })
                snackbar.setActionTextColor(Color.parseColor("#03dac6"))
                snackbar.show()
            }
        }
        val itemTouchhelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchhelper.attachToRecyclerView(recyclerView)
    }

}
