package com.example.workoutbuddy
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemMoveCallback(adapter:ItemTouchHelperContract): ItemTouchHelper.Callback() {
        private val mAdapter:ItemTouchHelperContract = adapter

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false
    }
        override fun onSwiped(@NonNull viewHolder:RecyclerView.ViewHolder, i:Int) {
        }
        override fun getMovementFlags(recyclerView:RecyclerView, viewHolder: RecyclerView.ViewHolder):Int {
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            return makeMovementFlags(dragFlags, 0)
        }
        override fun onMove(recyclerView:RecyclerView, viewHolder:RecyclerView.ViewHolder,
                   target:RecyclerView.ViewHolder):Boolean {
            mAdapter.onRowMoved(viewHolder.adapterPosition, target.adapterPosition)
            return true
        }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE)
            {
                if (viewHolder is ModelAdapter.ViewHolder)
                {
                    val myViewHolder = viewHolder as ModelAdapter.ViewHolder
                    mAdapter.onRowSelected(myViewHolder)
                }
            }
            super.onSelectedChanged(viewHolder, actionState)
        }
        override fun clearView(recyclerView:RecyclerView,
                      viewHolder:RecyclerView.ViewHolder) {
            super.clearView(recyclerView, viewHolder)
            if (viewHolder is ModelAdapter.ViewHolder)
            {
                val myViewHolder = viewHolder as ModelAdapter.ViewHolder
                mAdapter.onRowClear(myViewHolder)
            }
        }
        interface ItemTouchHelperContract {
            fun onBindViewHolder(holder:ModelAdapter.ViewHolder, position:Int)
            fun onRowMoved(fromPosition:Int, toPosition:Int)
            fun onRowSelected(myViewHolder:ModelAdapter.ViewHolder)
            fun onRowClear(myViewHolder:ModelAdapter.ViewHolder)
        }
}