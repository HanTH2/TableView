package com.evrencoskun.tableview.sort;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

/**
 * Created by cedricferry on 6/2/18.
 */

public class RowEndSortCallback extends DiffUtil.Callback {
    @NonNull
    private final List<ISortableModel> mOldCellItems;
    @NonNull
    private final List<ISortableModel> mNewCellItems;

    public RowEndSortCallback(@NonNull List<ISortableModel> oldCellItems, @NonNull List<ISortableModel>
            newCellItems) {
        this.mOldCellItems = oldCellItems;
        this.mNewCellItems = newCellItems;
    }

    @Override
    public int getOldListSize() {
        return mOldCellItems.size();
    }

    @Override
    public int getNewListSize() {
        return mNewCellItems.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        // Control for precaution from IndexOutOfBoundsException
        if (mOldCellItems.size() > oldItemPosition && mNewCellItems.size() > newItemPosition) {
            // Compare ids
            String oldId = mOldCellItems.get(oldItemPosition).getId();
            String newId = mNewCellItems.get(newItemPosition).getId();
            return oldId.equals(newId);
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        // Control for precaution from IndexOutOfBoundsException
        if (mOldCellItems.size() > oldItemPosition && mNewCellItems.size() > newItemPosition) {
            // Compare contents
            Object oldContent = mOldCellItems.get(oldItemPosition)
                    .getContent();
            Object newContent = mNewCellItems.get(newItemPosition)
                    .getContent();
            return oldContent.equals(newContent);
        }

        return false;
    }

}