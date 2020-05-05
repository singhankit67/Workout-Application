package com.example.workoutbuddy

import android.R.attr.data
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_onexerciseclick.view.*
import kotlinx.android.synthetic.main.row_cardview.view.*
import java.util.*


class ModelAdapter(private val arrayList: ArrayList<Model>, val context: Context):
    RecyclerView.Adapter<ModelAdapter.ViewHolder>(), ItemMoveCallback.ItemTouchHelperContract {
    //this defines that we want an array list where each element is int the form of model and it should be named as Model Adapter
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(model:Model){
            //here we have bind the id'S with the methods that we want to perform on that id's
            itemView.ExerciseName.text = model.name1
            itemView.timeDefined.text = model.time
            itemView.ExerciseImage.setImageResource(model.image)
            itemView.LLforBackground.setBackgroundResource(model.background1)
            itemView.ExerciseName.setTextColor(model.headingColor)
            itemView.timeDefined.setTextColor(model.descriptionColor)


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_cardview,parent,false) // tis means the changes should be made to this view
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return arrayList.size // this makes as many copies of the views as we want
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.itemView.setOnClickListener{//what this does is from main activity it comes to random then goes to onclick intent activity if this is not given then from main activity it directly jumps to onclick activity
        val model = arrayList[position]
        val gTitle = model.name1
        val gTime = model.time
        val gTitleColor = model.headingColor
        val gTimeColor = model.descriptionColor
        val intent = Intent(context,Onexerciseclick::class.java) //this is the link that get activated by clicking on a particular object
        intent.putExtra("iTitle" , gTitle)
        intent.putExtra("iTime" , gTime)
            intent.putExtra("iTitleColor" , gTitleColor)
            intent.putExtra("iTimeColor" , gTimeColor)
        //the above two putExtra are put because we have to use these values in other activity
        //now we start the onclick activity
        context.startActivity(intent)
    }
    }
    override fun onRowMoved(fromPosition:Int, toPosition:Int) {
        if (fromPosition < toPosition)
        {
            for (i in fromPosition until toPosition)
            {
                Collections.swap(arrayList, i, i + 1)
            }
        }
        else
        {
            for (i in fromPosition downTo toPosition + 1)
            {
                Collections.swap(arrayList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }
    override fun onRowSelected(myViewHolder:ViewHolder) {
        val card_view = myViewHolder.itemView.findViewById<LinearLayout>(R.id.LLforBackground1)
        card_view.setBackgroundColor(Color.parseColor("#33BB86FC"))

    }
    override fun onRowClear(myViewHolder: ViewHolder) {
        val card_view = myViewHolder.itemView.findViewById<LinearLayout>(R.id.LLforBackground1)
        card_view.setBackgroundResource(R.drawable.rect3)
    }
    fun removeItem(position: Int) {
        arrayList.removeAt(position)
        notifyItemRemoved(position)
    }
    fun restoreItem(item: Model, position: Int) {
        arrayList.add(position, item)
        notifyItemInserted(position)
    }
    fun getData(): ArrayList<Model>? {
        return arrayList
    }
}