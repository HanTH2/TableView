package com.evrencoskun.tableviewsample.tableview.popup

import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.evrencoskun.tableview.TableView
import com.evrencoskun.tableviewsample.R


/**
 * Created by evrencoskun on 21.01.2018.
 */
class RowHeaderLongPressPopup(
    viewHolder: RecyclerView.ViewHolder,
    private val mTableView: TableView
) :
    PopupMenu(viewHolder.itemView.context, viewHolder.itemView), PopupMenu.OnMenuItemClickListener {
    private val mRowPosition: Int
    private fun initialize() {
        createMenuItem()
        setOnMenuItemClickListener(this)
    }

    private fun createMenuItem() {
        val context = mTableView.context
        this.menu.add(
            Menu.NONE,
            SCROLL_COLUMN,
            0,
            context.getString(R.string.scroll_to_column_position)
        )
        this.menu.add(
            Menu.NONE,
            SHOWHIDE_COLUMN,
            1,
            context.getString(R.string.show_hide_the_column)
        )
        this.menu.add(
            Menu.NONE, REMOVE_ROW, 2,
            "Remove $mRowPosition position"
        )
        // add new one ...
    }

    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
        // Note: item id is index of menu item..
        when (menuItem.itemId) {
            SCROLL_COLUMN -> mTableView.scrollToColumnPosition(15)
            SHOWHIDE_COLUMN -> {
                val column = 1
                if (mTableView.isColumnVisible(column)) {
                    mTableView.hideColumn(column)
                } else {
                    mTableView.showColumn(column)
                }
            }
            REMOVE_ROW -> mTableView.adapter!!.removeRow(mRowPosition)
        }
        return true
    }

    companion object {
        // Menu Item constants
        private const val SCROLL_COLUMN = 1
        private const val SHOWHIDE_COLUMN = 2
        private const val REMOVE_ROW = 3
    }

    init {
        mRowPosition = viewHolder.bindingAdapterPosition
        initialize()
    }
}