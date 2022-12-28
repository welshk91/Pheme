package com.welshk.pheme.views

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


/**
 * https://stackoverflow.com/questions/66194354/recyclerview-itemdecoration-vs-margin-for-spacing-between-recyclerview-items
 */
class ArticleItemDecoration(
    private val marginTopBottom: Int,
    private val marginSide: Int = marginTopBottom
) :
    ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = marginTopBottom
            }
            left = marginSide
            right = marginSide
            bottom = marginTopBottom
        }
    }
}