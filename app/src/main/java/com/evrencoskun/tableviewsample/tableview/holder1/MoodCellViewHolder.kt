package com.evrencoskun.tableviewsample.tableview.holder1

import android.view.View
import android.widget.ImageView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.evrencoskun.tableviewsample.R
import com.evrencoskun.tableviewsample.tableview.TableViewModel

/**
 * Created by evrencoskun on 4.02.2018.
 */
class MoodCellViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    val cell_image: ImageView
    fun setData(data: Any) {
        val mood = data as Int
        val moodDrawable =
            if (mood == TableViewModel.HAPPY) R.drawable.ic_happy else R.drawable.ic_sad
        cell_image.setImageResource(moodDrawable)
    }

    init {
        cell_image = itemView.findViewById(R.id.cell_image)
    }
}