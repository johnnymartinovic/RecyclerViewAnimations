package com.johnnym.recyclerviewanimations.common

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class MarginItemDecoration(
        private val margin: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = margin
        outRect.bottom = margin
        outRect.left = margin
        outRect.right = margin
    }
}
