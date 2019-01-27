package com.johnnym.recyclerviewanimations.travelino

import kotlin.math.roundToInt

class TravelinoViewModelMapper {

    companion object {
        private const val PRICE_PREFIX = "$"
        private const val ORIGINAL_PRICE_PREFIX = "Was $"
    }

    fun map(item: TravelinoItem): TravelinoItemViewModel {
        return TravelinoItemViewModel(
                item.id,
                item.name,
                "$PRICE_PREFIX%d".format(item.price),
                "$ORIGINAL_PRICE_PREFIX%d".format(item.originalPrice),
                "${item.discountPercentage.roundToInt()}%",
                item.imageUrl,
                item.infoMessage)
    }
}