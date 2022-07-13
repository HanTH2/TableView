package com.evrencoskun.tableviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
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
    private var mllContent: LinearLayout? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Let's get TableView
        mTableView = view.findViewById(R.id.tableview)
        mllContent = view.findViewById(R.id.llContent)

        initBottomSheet(view)

        initializeTableView()
    }

    private fun initBottomSheet(view: View) {
        val sheetContent = view.findViewById<FrameLayout>(R.id.sheet_container)
        val bottomSheetBehavior = BottomSheetBehavior.from(sheetContent)

        // set callback for changes
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        mTableView?.clipToPadding = true
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        mTableView?.setPadding(0, 0, 0, 0)
                        mTableView?.clipToPadding = true
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        mllContent?.height?.let {
                            mTableView?.setPadding(0, 0, 0, it + 30)
                            mTableView?.clipToPadding = true
                        }
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        mTableView?.setPadding(0, 0, 0, 0)
                        mTableView?.clipToPadding = true
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        mTableView?.clipToPadding = true
                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
        view.post {
            mllContent?.height?.let {
                mTableView?.setPadding(0, 0, 0, it + 30)
                mTableView?.clipToPadding = true
            }
        }
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