package com.johnnym.recyclerviewanimations.diffutildemo

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.johnnym.recyclerviewanimations.R
import com.johnnym.recyclerviewanimations.common.Change
import com.johnnym.recyclerviewanimations.common.createCombinedPayload
import com.johnnym.recyclerviewanimations.travelino.TravelinoItemViewModel
import com.johnnym.recyclerviewanimations.travelino.TravelinoItemView
import com.johnnym.recyclerviewanimations.travelino.TravelinoItemViewHolder

class DiffUtilDemoAdapter : RecyclerView.Adapter<TravelinoItemViewHolder>() {

    private var items = mutableListOf<TravelinoItemViewModel>()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelinoItemViewHolder {
        val context = parent.context
        return TravelinoItemViewHolder(context, TravelinoItemView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    context.resources.getDimensionPixelSize(R.dimen.travelino_item_height))
        })
    }

    override fun onBindViewHolder(holder: TravelinoItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onBindViewHolder(holder: TravelinoItemViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val combinedChange = createCombinedPayload(payloads as List<Change<TravelinoItemViewModel>>)
            val oldData = combinedChange.oldData
            val newData = combinedChange.newData

            if (newData.price != oldData.price) {
                holder.view.price.text = newData.price
            }

            if (newData.discountPercentage != oldData.discountPercentage) {
                holder.view.discountPercentage.text = newData.discountPercentage
            }

            if (newData.infoMessage != oldData.infoMessage) {
                holder.view.infoMessage.text = newData.infoMessage
            }
        }
    }

    fun setItems(newItems: List<TravelinoItemViewModel>) {
        val result = DiffUtil.calculateDiff(TravelinoListDiffUtilCallback(this.items, newItems))
        result.dispatchUpdatesTo(this)
        this.items.clear()
        this.items.addAll(newItems)
    }

    class TravelinoListDiffUtilCallback(
            private var oldItems: List<TravelinoItemViewModel>,
            private var newItems: List<TravelinoItemViewModel>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldItems.size

        override fun getNewListSize(): Int = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                oldItems[oldItemPosition].id == newItems[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                oldItems[oldItemPosition] == newItems[newItemPosition]

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            return Change(
                    oldItem,
                    newItem)
        }
    }
}
