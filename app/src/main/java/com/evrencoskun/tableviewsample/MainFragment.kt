package com.evrencoskun.tableviewsample

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.evrencoskun.tableview.TableView
import com.evrencoskun.tableviewsample.tableview.TableViewAdapter
import com.evrencoskun.tableviewsample.tableview.TableViewListener
import com.evrencoskun.tableviewsample.tableview.TableViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(R.layout.fragment_main) {
    private var mTableView: TableView? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Let's get TableView
        mTableView = view.findViewById(R.id.tableview)
        val sheetContent = view.findViewById<LinearLayout>(R.id.sheet_container)
        BottomSheetBehavior.from(sheetContent)

        initializeTableView()
    }

    private fun initializeTableView() {
        // Create TableView View model class  to group view models of TableView
        val tableViewModel = TableViewModel()

        // Create TableView Adapter
        val tableViewAdapter = TableViewAdapter(tableViewModel)
        mTableView!!.setAdapter(tableViewAdapter)
        mTableView!!.tableViewListener = TableViewListener(mTableView!!)

        // Create an instance of a Filter and pass the TableView.
        //mTableFilter = new Filter(mTableView);

        // Load the dummy data to the TableView
        tableViewAdapter.setAllItems(
            tableViewModel.columnHeaderList, tableViewModel
                .rowHeaderList, tableViewModel.rowEndList, tableViewModel.cellList
        )

        //mTableView.setHasFixedWidth(true);

        /*for (int i = 0; i < mTableViewModel.getCellList().size(); i++) {
            mTableView.setColumnWidth(i, 200);
        }*)

        //mTableView.setColumnWidth(0, -2);
        //mTableView.setColumnWidth(1, -2);

        / *mTableView.setColumnWidth(2, 200);
        mTableView.setColumnWidth(3, 300);
        mTableView.setColumnWidth(4, 400);
        mTableView.setColumnWidth(5, 500);*/
    }
}