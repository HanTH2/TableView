package com.evrencoskun.tableviewsample.tableview.holder

import android.view.View
import android.widget.TextView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.evrencoskun.tableviewsample.R


/**
 * Created by evrencoskun on 23/10/2017.
 */
class RowEndViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    val row_end_textview: TextView

    init {
        row_end_textview = itemView.findViewById(R.id.row_end_textview)
    }
}