package com.evrencoskun.tableviewsample.tableview.holder1

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.evrencoskun.tableviewsample.R
import com.evrencoskun.tableviewsample.tableview.model.Cell


/**
 * Created by evrencoskun on 23/10/2017.
 */
class CellViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    private val cell_textview: TextView
    private val cell_container: LinearLayout
    fun setCell(cell: Cell?) {
        cell_textview.text = cell!!.data.toString()

        // If your TableView should have auto resize for cells & columns.
        // Then you should consider the below lines. Otherwise, you can ignore them.

        // It is necessary to remeasure itself.
        cell_container.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        cell_textview.requestLayout()
    }

    init {
        cell_textview = itemView.findViewById(R.id.cell_data)
        cell_container = itemView.findViewById(R.id.cell_container)
    }
}
