package com.evrencoskun.tableviewsample.tableview.model

import com.evrencoskun.tableview.filter.IFilterableModel
import com.evrencoskun.tableview.sort.ISortableModel


/**
 * Created by evrencoskun on 11/06/2017.
 */
open class Cell(private val mId: String, val data: Any?) : ISortableModel,
    IFilterableModel {
    private val mFilterKeyword: String

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    override fun getId(): String {
        return mId
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    override fun getContent(): Any? {
        return data
    }

    override fun getFilterableKeyword(): String {
        return mFilterKeyword
    }

    init {
        mFilterKeyword = data.toString()
    }
}