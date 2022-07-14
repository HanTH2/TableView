package com.evrencoskun.tableviewsample.tableview.holder

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.evrencoskun.tableview.ITableView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder
import com.evrencoskun.tableview.sort.SortState
import com.evrencoskun.tableviewsample.R
import com.evrencoskun.tableviewsample.tableview.model.ColumnHeader


/**
 * Created by evrencoskun on 23/10/2017.
 */
class ColumnHeaderViewHolder(itemView: View, private val tableView: ITableView?) :
    AbstractSorterViewHolder(itemView) {
    private val column_header_container: LinearLayout
    private val column_header_textview: TextView
    private val column_header_sortButton: ImageButton

    /**
     * This method is calling from onBindColumnHeaderHolder on TableViewAdapter
     */
    fun setColumnHeader(columnHeader: ColumnHeader?) {
        column_header_textview.text = columnHeader!!.data.toString()

        // If your TableView should have auto resize for cells & columns.
        // Then you should consider the below lines. Otherwise, you can remove them.

        // It is necessary to remeasure itself.
        column_header_container.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        column_header_container.requestLayout()
    }

    private val mSortButtonClickListener = View.OnClickListener {
        if (sortState == SortState.ASCENDING) {
            tableView!!.sortColumn(bindingAdapterPosition, SortState.DESCENDING)
        } else if (sortState == SortState.DESCENDING) {
            tableView!!.sortColumn(bindingAdapterPosition, SortState.ASCENDING)
        } else {
            // Default one
            tableView!!.sortColumn(bindingAdapterPosition, SortState.DESCENDING)
        }
    }

    override fun onSortingStatusChanged(sortState: SortState) {
        Log.e(
            LOG_TAG, " + onSortingStatusChanged: x:  " + bindingAdapterPosition + ", " +
                    "old state: " + getSortState() + ", current state: " + sortState + ", " +
                    "visibility: " + column_header_sortButton.visibility
        )
        super.onSortingStatusChanged(sortState)

        // It is necessary to remeasure itself.
        column_header_container.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        controlSortState(sortState)
        Log.e(
            LOG_TAG, " - onSortingStatusChanged: x:  " + bindingAdapterPosition + ", " +
                    "old state: " + getSortState() + ", current state: " + sortState + ", " +
                    "visibility: " + column_header_sortButton.visibility
        )
        column_header_textview.requestLayout()
        column_header_sortButton.requestLayout()
        column_header_container.requestLayout()
        itemView.requestLayout()
    }

    private fun controlSortState(sortState: SortState) {
        if (sortState == SortState.ASCENDING) {
            column_header_sortButton.visibility = View.VISIBLE
            column_header_sortButton.setImageResource(R.drawable.ic_down)
        } else if (sortState == SortState.DESCENDING) {
            column_header_sortButton.visibility = View.VISIBLE
            column_header_sortButton.setImageResource(R.drawable.ic_up)
        } else {
            column_header_sortButton.visibility = View.INVISIBLE
        }
    }

    companion object {
        private val LOG_TAG: String = ColumnHeaderViewHolder::class.java.getSimpleName()
    }

    init {
        column_header_textview = itemView.findViewById(R.id.column_header_textView)
        column_header_container = itemView.findViewById(R.id.column_header_container)
        column_header_sortButton = itemView.findViewById(R.id.column_header_sortButton)

        // Set click listener to the sort button
        column_header_sortButton.setOnClickListener(mSortButtonClickListener)
    }
}