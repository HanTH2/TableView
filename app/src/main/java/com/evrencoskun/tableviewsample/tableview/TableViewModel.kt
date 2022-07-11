package com.evrencoskun.tableviewsample.tableview

import androidx.annotation.DrawableRes
import com.evrencoskun.tableviewsample.R
import com.evrencoskun.tableviewsample.tableview.model.Cell
import com.evrencoskun.tableviewsample.tableview.model.ColumnHeader
import com.evrencoskun.tableviewsample.tableview.model.RowEnd
import com.evrencoskun.tableviewsample.tableview.model.RowHeader
import java.util.*


/**
 * Created by evrencoskun on 4.02.2018.
 */
class TableViewModel {
    // Drawables
    @DrawableRes
    private val mHappyDrawable: Int

    @DrawableRes
    private val mSadDrawable: Int
    private val simpleRowHeaderList: List<RowHeader>
        private get() {
            val list: MutableList<RowHeader> = ArrayList()
            for (i in 0 until ROW_SIZE) {
                val header = RowHeader(
                    i.toString(),
                    "row $i"
                )
                list.add(header)
            }
            return list
        }
    private val simpleRowEndList: List<RowEnd>
        private get() {
            val list: MutableList<RowEnd> = ArrayList()
            for (i in 0 until ROW_SIZE) {
                val end = RowEnd(i.toString(), "End $i")
                list.add(end)
            }
            return list
        }

    /**
     * This is a dummy model list test some cases.
     */
    private val randomColumnHeaderList: List<ColumnHeader>
        private get() {
            val list: MutableList<ColumnHeader> = ArrayList()
            for (i in 0 until COLUMN_SIZE) {
                var title = "column $i"
                val nRandom = Random().nextInt()
                if (nRandom % 4 == 0 || nRandom % 3 == 0 || nRandom == i) {
                    title = "large column $i"
                }
                val header = ColumnHeader(i.toString(), title)
                list.add(header)
            }
            return list
        }// NOTE female and male keywords for filter will have conflict since "female"
    // contains "male"
// Create dummy id.
    /**
     * This is a dummy model list test some cases.
     */
    private val cellListForSortingTest: List<List<Cell>>
        private get() {
            val list: MutableList<List<Cell>> = ArrayList()
            for (i in 0 until ROW_SIZE) {
                val cellList: MutableList<Cell> = ArrayList()
                for (j in 0 until COLUMN_SIZE) {
                    var text: Any? = "cell $j $i"
                    val random = Random().nextInt()
                    if (j == 0) {
                        text = i
                    } else if (j == 1) {
                        text = random
                    } else if (j == MOOD_COLUMN_INDEX) {
                        text = if (random % 2 == 0) HAPPY else SAD
                    }

                    // Create dummy id.
                    val id: String = j.toString() + "-" + i
                    var cell: Cell
                    cell = if (j == 3) {
                        Cell(id, text)
                    } else if (j == 4) {
                        // NOTE female and male keywords for filter will have conflict since "female"
                        // contains "male"
                        Cell(id, text)
                    } else {
                        Cell(id, text)
                    }
                    cellList.add(cell)
                }
                list.add(cellList)
            }
            return list
        }

    @DrawableRes
    fun getDrawable(value: Int, isGender: Boolean): Int {
//        if (isGender) {
//            return value == BOY ? mBoyDrawable : mGirlDrawable;
//        } else {
        return if (value == SAD) mSadDrawable else mHappyDrawable
        //        }
    }

    val cellList: List<List<Cell>>
        get() = cellListForSortingTest
    val rowHeaderList: List<RowHeader>
        get() = simpleRowHeaderList
    val rowEndList: List<RowEnd>
        get() = simpleRowEndList
    val columnHeaderList: List<ColumnHeader>
        get() = randomColumnHeaderList

    companion object {
        // Columns indexes
        const val MOOD_COLUMN_INDEX = 9

        // Constant values for icons
        const val SAD = 1
        const val HAPPY = 2

        // Constant size for dummy data sets
        private const val COLUMN_SIZE = 10
        private const val ROW_SIZE = 30
    }

    init {
        // initialize drawables
        mHappyDrawable = R.drawable.ic_happy
        mSadDrawable = R.drawable.ic_sad
    }
}