package com.evrencoskun.tableview.adapter.recyclerview;


import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.adapter.ITableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder.SelectionState;
import com.evrencoskun.tableview.sort.RowEndSortHelper;

import java.util.List;

/**
 * Created by evrencoskun on 10/06/2017.
 */

public class RowEndRecyclerViewAdapter<RE> extends AbstractRecyclerViewAdapter<RE> {
    @NonNull
    private final ITableAdapter mTableAdapter;
    private final ITableView mTableView;
    private RowEndSortHelper mRowEndSortHelper;

    public RowEndRecyclerViewAdapter(@NonNull Context context, @Nullable List<RE> itemList, @NonNull ITableAdapter
            tableAdapter) {
        super(context, itemList);
        this.mTableAdapter = tableAdapter;
        this.mTableView = tableAdapter.getTableView();
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mTableAdapter.onCreateRowEndViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder holder, int position) {
        mTableAdapter.onBindRowEndViewHolder(holder, getItem(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        return mTableAdapter.getRowEndItemViewType(position);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull AbstractViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);

        SelectionState selectionState = mTableView.getSelectionHandler().getRowSelectionState
                (viewHolder.getBindingAdapterPosition());

        // Control to ignore selection color
        if (!mTableView.isIgnoreSelectionColors()) {

            // Change background color of the view considering it's selected state
            mTableView.getSelectionHandler().changeRowBackgroundColorBySelectionStatus
                    (viewHolder, selectionState);
        }

        // Change selection status
        viewHolder.setSelected(selectionState);
    }

    @NonNull
    public RowEndSortHelper getRowEndSortHelper() {
        if (mRowEndSortHelper == null) {
            // It helps to store sorting state of row headers
            this.mRowEndSortHelper = new RowEndSortHelper();
        }
        return mRowEndSortHelper;
    }
}
