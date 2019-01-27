package com.johnnym.recyclerviewanimations.travelino

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.rstanic12.resourceful.bindDimen
import com.johnnym.recyclerviewanimations.R
import com.johnnym.recyclerviewanimations.common.bindView

class TravelinoItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val itemElevation by bindDimen(R.dimen.travelino_item_elevation)

    val image: ImageView by bindView(R.id.image)
    val title: TextView by bindView(R.id.title)
    val price: TextView by bindView(R.id.price)
    val originalPrice: TextView by bindView(R.id.originalPrice)
    val discountPercentage: TextView by bindView(R.id.discountPercentage)
    val infoMessage: TextView by bindView(R.id.infoMessage)

    init {
        LayoutInflater.from(context).inflate(R.layout.travelino_item, this, true)

        setBackgroundResource(R.drawable.travelino_item_background)
        clipToOutline = true

        elevation = itemElevation
    }
}
