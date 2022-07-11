package com.evrencoskun.tableviewsample.tableview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.evrencoskun.tableview.sort.SortState
import com.evrencoskun.tableviewsample.R
import com.evrencoskun.tableviewsample.tableview.holder.*
import com.evrencoskun.tableviewsample.tableview.model.Cell
import com.evrencoskun.tableviewsample.tableview.model.ColumnHeader
import com.evrencoskun.tableviewsample.tableview.model.RowEnd
import com.evrencoskun.tableviewsample.tableview.model.RowHeader


/**
 * Created by evrencoskun on 11/06/2017.
 *
 *
 * This is a sample of custom TableView Adapter.
 */
class TableViewAdapter(private val mTableViewModel: TableViewModel) :
    AbstractTableAdapter<ColumnHeader?, RowHeader?, RowEnd?, Cell?>() {
    /**
     * This is where you create your custom Cell ViewHolder. This method is called when Cell
     * RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given type to
     * represent an item.
     *
     * @param viewType : This value comes from "getCellItemViewType" method to support different
     * type of viewHolder as a Cell item.
     * @see .getCellItemViewType
     */
    override fun onCreateCellViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        //TODO check
        Log.e(LOG_TAG, " onCreateCellViewHolder has been called")
        val inflater = LayoutInflater.from(parent.context)
        val layout: View
        return when (viewType) {
            MOOD_CELL_TYPE -> {
                // Get image cell layout which has ImageView on the base instead of TextView.
                layout = inflater.inflate(R.layout.table_view_image_cell_layout, parent, false)
                MoodCellViewHolder(layout)
            }
            else -> {
                // For cells that display a text
                layout = inflater.inflate(R.layout.table_view_cell_layout, parent, false)

                // Create a Cell ViewHolder
                CellViewHolder(layout)
            }
        }
    }

    /**
     * That is where you set Cell View Model data to your custom Cell ViewHolder. This method is
     * Called by Cell RecyclerView of the TableView to display the data at the specified position.
     * This method gives you everything you need about a cell item.
     *
     * @param holder         : This is one of your cell ViewHolders that was created on
     * ```onCreateCellViewHolder``` method. In this example we have created
     * "CellViewHolder" holder.
     * @param cellItemModel  : This is the cell view model located on this X and Y position. In this
     * example, the model class is "Cell".
     * @param columnPosition : This is the X (Column) position of the cell item.
     * @param rowPosition    : This is the Y (Row) position of the cell item.
     * @see .onCreateCellViewHolder
     */
    override fun onBindCellViewHolder(
        holder: AbstractViewHolder,
        cellItemModel: Cell?,
        columnPosition: Int,
        rowPosition: Int
    ) {
        when (holder.itemViewType) {
            MOOD_CELL_TYPE -> {
                val moodViewHolder = holder as MoodCellViewHolder
                moodViewHolder.cell_image.setImageResource(
                    mTableViewModel.getDrawable(
                        cellItemModel
                            ?.data as Int, false
                    )
                )
            }
            else -> {
                // Get the holder to update cell item text
                val viewHolder = holder as CellViewHolder
                viewHolder.setCell(cellItemModel)
            }
        }
    }

    /**
     * This is where you create your custom Column Header ViewHolder. This method is called when
     * Column Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getColumnHeaderItemViewType" method to support
     * different type of viewHolder as a Column Header item.
     * @see .getColumnHeaderItemViewType
     */
    override fun onCreateColumnHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder {
        // TODO: check
        //Log.e(LOG_TAG, " onCreateColumnHeaderViewHolder has been called");
        // Get Column Header xml Layout
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_column_header_layout, parent, false)

        // Create a ColumnHeader ViewHolder
        return ColumnHeaderViewHolder(layout, tableView)
    }

    /**
     * That is where you set Column Header View Model data to your custom Column Header ViewHolder.
     * This method is Called by ColumnHeader RecyclerView of the TableView to display the data at
     * the specified position. This method gives you everything you need about a column header
     * item.
     *
     * @param holder                : This is one of your column header ViewHolders that was created
     * on ```onCreateColumnHeaderViewHolder``` method. In this example
     * we have created "ColumnHeaderViewHolder" holder.
     * @param columnHeaderItemModel : This is the column header view model located on this X
     * position. In this example, the model class is "ColumnHeader".
     * @param columnPosition        : This is the X (Column) position of the column header item.
     * @see .onCreateColumnHeaderViewHolder
     */
    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder,
        columnHeaderItemModel: ColumnHeader?,
        columnPosition: Int
    ) {

        // Get the holder to update cell item text
        val columnHeaderViewHolder = holder as ColumnHeaderViewHolder
        columnHeaderViewHolder.setColumnHeader(columnHeaderItemModel)
    }

    /**
     * This is where you create your custom Row Header ViewHolder. This method is called when
     * Row Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getRowHeaderItemViewType" method to support
     * different type of viewHolder as a row Header item.
     * @see .getRowHeaderItemViewType
     */
    override fun onCreateRowHeaderViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        // Get Row Header xml Layout
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_row_header_layout, parent, false)

        // Create a Row Header ViewHolder
        return RowHeaderViewHolder(layout)
    }

    /**
     * That is where you set Row Header View Model data to your custom Row Header ViewHolder. This
     * method is Called by RowHeader RecyclerView of the TableView to display the data at the
     * specified position. This method gives you everything you need about a row header item.
     *
     * @param holder             : This is one of your row header ViewHolders that was created on
     * ```onCreateRowHeaderViewHolder``` method. In this example we have
     * created "RowHeaderViewHolder" holder.
     * @param rowHeaderItemModel : This is the row header view model located on this Y position. In
     * this example, the model class is "RowHeader".
     * @param rowPosition        : This is the Y (row) position of the row header item.
     * @see .onCreateRowHeaderViewHolder
     */
    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder, rowHeaderItemModel: RowHeader?,
        rowPosition: Int
    ) {

        // Get the holder to update row header item text
        val rowHeaderViewHolder = holder as RowHeaderViewHolder
        rowHeaderViewHolder.row_header_textview.text = rowHeaderItemModel!!.data.toString()
    }

    /**
     * This is where you create your custom Row Header ViewHolder. This method is called when
     * Row Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getRowHeaderItemViewType" method to support
     * different type of viewHolder as a row Header item.
     * @see .getRowHeaderItemViewType
     */
    override fun onCreateRowEndViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        // Get Row Header xml Layout
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_row_end_layout, parent, false)

        // Create a Row Header ViewHolder
        return RowEndViewHolder(layout)
    }

    /**
     * That is where you set Row End View Model data to your custom Row End ViewHolder. This
     * method is Called by RowEnd RecyclerView of the TableView to display the data at the
     * specified position. This method gives you everything you need about a row header item.
     *
     * @param holder             : This is one of your row header ViewHolders that was created on
     * ```onCreateRowHeaderViewHolder``` method. In this example we have
     * created "RowHeaderViewHolder" holder.
     * @param rowEndItemModel : This is the row header view model located on this Y position. In
     * this example, the model class is "RowHeader".
     * @param rowPosition        : This is the Y (row) position of the row header item.
     * @see .onCreateRowHeaderViewHolder
     */
    override fun onBindRowEndViewHolder(
        holder: AbstractViewHolder, rowEndItemModel: RowEnd?,
        rowPosition: Int
    ) {

        // Get the holder to update row header item text
        val rowEndViewHolder = holder as RowEndViewHolder
        rowEndViewHolder.row_end_textview.text = rowEndItemModel!!.data.toString()
    }

    override fun onCreateCornerView(parent: ViewGroup): View {
        // Get Corner xml layout
        val corner = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_corner_layout, parent, false)
        corner.setOnClickListener { view: View? ->
            val sortState = this@TableViewAdapter.tableView
                .rowHeaderSortingStatus
            if (sortState != SortState.ASCENDING) {
                Log.d("TableViewAdapter", "Order Ascending")
                this@TableViewAdapter.tableView.sortRowHeader(SortState.ASCENDING)
            } else {
                Log.d("TableViewAdapter", "Order Descending")
                this@TableViewAdapter.tableView.sortRowHeader(SortState.DESCENDING)
            }
        }
        return corner
    }

    override fun onCreateCornerEndView(parent: ViewGroup): View {
        // Get Corner xml layout
        val corner = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_corner_end_layout, parent, false)
        corner.setOnClickListener { view: View? ->
            val sortState = this@TableViewAdapter.tableView
                .rowEndSortingStatus
            if (sortState != SortState.ASCENDING) {
                Log.d("TableViewAdapter", "Order Ascending")
                this@TableViewAdapter.tableView.sortRowEnd(SortState.ASCENDING)
            } else {
                Log.d("TableViewAdapter", "Order Descending")
                this@TableViewAdapter.tableView.sortRowEnd(SortState.DESCENDING)
            }
        }
        return corner
    }

    override fun getColumnHeaderItemViewType(position: Int): Int {
        // The unique ID for this type of column header item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return 0
    }

    override fun getRowHeaderItemViewType(position: Int): Int {
        // The unique ID for this type of row header item
        // If you have different items for Row Header View by Y (Row) position,
        // then you should fill this method to be able create different
        // type of RowHeaderViewHolder on "onCreateRowHeaderViewHolder"
        return 0
    }

    override fun getRowEndItemViewType(position: Int): Int {
        // The unique ID for this type of row end item
        // If you have different items for Row end View by Y (Row) position,
        // then you should fill this method to be able create different
        // type of RowHeaderViewHolder on "onCreateRowEndViewHolder"
        return 0
    }

    override fun getCellItemViewType(column: Int): Int {

        // The unique ID for this type of cell item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return when (column) {
            TableViewModel.MOOD_COLUMN_INDEX -> MOOD_CELL_TYPE
            else ->                 // Default view type
                0
        }
    }

    companion object {
        // Cell View Types by Column Position
        private const val MOOD_CELL_TYPE = 1

        // add new one if it necessary..
        private val LOG_TAG: String = TableViewAdapter::class.java.getSimpleName()
    }
}