package com.evrencoskun.tableviewsample.tableview.holder1

import android.view.View
import android.widget.TextView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.evrencoskun.tableviewsample.R


/**
 * Created by evrencoskun on 23/10/2017.
 */
class RowHeaderViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    val row_header_textview: TextView

    init {
        row_header_textview = itemView.findViewById(R.id.row_header_textview)
    }
}