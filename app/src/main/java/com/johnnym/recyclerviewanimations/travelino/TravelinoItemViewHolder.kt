package com.johnnym.recyclerviewanimations.travelino

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TravelinoItemViewHolder(
        private val context: Context,
        val view: TravelinoItemView
) : RecyclerView.ViewHolder(view) {

    fun bind(viewModel: TravelinoItemViewModel) {
        view.title.text = viewModel.name
        view.price.text = viewModel.price
        view.originalPrice.text = viewModel.originalPriceText
        view.discountPercentage.text = viewModel.discountPercentage
        view.infoMessage.text = viewModel.infoMessage

        Glide.with(context)
                .load(viewModel.imageUrl)
                .apply(RequestOptions()
                        .placeholder(android.R.color.white)
                        .error(android.R.color.black)
                        .dontAnimate())
                .into(view.image)
    }
}
