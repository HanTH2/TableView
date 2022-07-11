package com.evrencoskun.tableviewsample.tableview

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.evrencoskun.tableview.TableView
import com.evrencoskun.tableview.listener.ITableViewListener
import com.evrencoskun.tableviewsample.tableview.holder.ColumnHeaderViewHolder
import com.evrencoskun.tableviewsample.tableview.popup.ColumnHeaderLongPressPopup
import com.evrencoskun.tableviewsample.tableview.popup.RowEndLongPressPopup
import com.evrencoskun.tableviewsample.tableview.popup.RowHeaderLongPressPopup


/**
 * Created by evrencoskun on 21/09/2017.
 */
class TableViewListener(tableView: TableView) :
    ITableViewListener {
    private val mContext: Context
    private val mTableView: TableView

    /**
     * Called when user click any cell item.
     *
     * @param cellView : Clicked Cell ViewHolder.
     * @param column   : X (Column) position of Clicked Cell item.
     * @param row      : Y (Row) position of Clicked Cell item.
     */
    override fun onCellClicked(cellView: RecyclerView.ViewHolder, column: Int, row: Int) {

        // Do what you want.
        showToast("Cell $column $row has been clicked.")
    }

    /**
     * Called when user double click any cell item.
     *
     * @param cellView : Clicked Cell ViewHolder.
     * @param column   : X (Column) position of Clicked Cell item.
     * @param row      : Y (Row) position of Clicked Cell item.
     */
    override fun onCellDoubleClicked(cellView: RecyclerView.ViewHolder, column: Int, row: Int) {
        // Do what you want.
        showToast("Cell $column $row has been double clicked.")
    }

    /**
     * Called when user long press any cell item.
     *
     * @param cellView : Long Pressed Cell ViewHolder.
     * @param column   : X (Column) position of Long Pressed Cell item.
     * @param row      : Y (Row) position of Long Pressed Cell item.
     */
    override fun onCellLongPressed(
        cellView: RecyclerView.ViewHolder, column: Int,
        row: Int
    ) {
        // Do What you want
        showToast("Cell $column $row has been long pressed.")
    }

    /**
     * Called when user click any column header item.
     *
     * @param columnHeaderView : Clicked Column Header ViewHolder.
     * @param column           : X (Column) position of Clicked Column Header item.
     */
    override fun onColumnHeaderClicked(columnHeaderView: RecyclerView.ViewHolder, column: Int) {
        // Do what you want.
        showToast("Column header  $column has been clicked.")
    }

    /**
     * Called when user double click any column header item.
     *
     * @param columnHeaderView : Clicked Column Header ViewHolder.
     * @param column           : X (Column) position of Clicked Column Header item.
     */
    override fun onColumnHeaderDoubleClicked(
        columnHeaderView: RecyclerView.ViewHolder,
        column: Int
    ) {
        // Do what you want.
        showToast("Column header  $column has been double clicked.")
    }

    /**
     * Called when user long press any column header item.
     *
     * @param columnHeaderView : Long Pressed Column Header ViewHolder.
     * @param column           : X (Column) position of Long Pressed Column Header item.
     */
    override fun onColumnHeaderLongPressed(columnHeaderView: RecyclerView.ViewHolder, column: Int) {
        if (columnHeaderView is ColumnHeaderViewHolder) {
            // Create Long Press Popup
            val popup = ColumnHeaderLongPressPopup(
                columnHeaderView, mTableView
            )
            // Show
            popup.show()
        }
    }

    /**
     * Called when user click any Row Header item.
     *
     * @param rowHeaderView : Clicked Row Header ViewHolder.
     * @param row           : Y (Row) position of Clicked Row Header item.
     */
    override fun onRowHeaderClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int) {
        // Do whatever you want.
        showToast("Row header $row has been clicked.")
    }

    /**
     * Called when user double click any Row Header item.
     *
     * @param rowHeaderView : Clicked Row Header ViewHolder.
     * @param row           : Y (Row) position of Clicked Row Header item.
     */
    override fun onRowHeaderDoubleClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int) {
        // Do whatever you want.
        showToast("Row header $row has been double clicked.")
    }

    /**
     * Called when user long press any row header item.
     *
     * @param rowHeaderView : Long Pressed Row Header ViewHolder.
     * @param row           : Y (Row) position of Long Pressed Row Header item.
     */
    override fun onRowHeaderLongPressed(rowHeaderView: RecyclerView.ViewHolder, row: Int) {

        // Create Long Press Popup
        val popup = RowHeaderLongPressPopup(rowHeaderView, mTableView)
        // Show
        popup.show()
    }

    /**
     * Called when user click any Row Header item.
     *
     * @param rowHeaderView : Clicked Row Header ViewHolder.
     * @param row           : Y (Row) position of Clicked Row Header item.
     */
    override fun onRowEndClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int) {
        // Do whatever you want.
        showToast("Row end $row has been clicked.")
    }

    /**
     * Called when user double click any Row Header item.
     *
     * @param rowHeaderView : Clicked Row Header ViewHolder.
     * @param row           : Y (Row) position of Clicked Row Header item.
     */
    override fun onRowEndDoubleClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int) {
        // Do whatever you want.
        showToast("Row End $row has been double clicked.")
    }

    /**
     * Called when user long press any row header item.
     *
     * @param rowEndView : Long Pressed Row Header ViewHolder.
     * @param row           : Y (Row) position of Long Pressed Row Header item.
     */
    override fun onRowEndLongPressed(rowEndView: RecyclerView.ViewHolder, row: Int) {

        // Create Long Press Popup
        val popup = RowEndLongPressPopup(rowEndView, mTableView)
        // Show
        popup.show()
    }

    private fun showToast(p_strMessage: String) {
        Toast.makeText(mContext, p_strMessage, Toast.LENGTH_SHORT).show()
    }

    init {
        mContext = tableView.context
        mTableView = tableView
    }
}