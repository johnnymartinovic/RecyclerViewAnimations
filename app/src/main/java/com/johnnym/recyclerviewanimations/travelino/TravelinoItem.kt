package com.johnnym.recyclerviewanimations.travelino

data class TravelinoItem(
        val id: String,
        val name: String,
        val price: Int,
        val originalPrice: Int,
        val imageUrl: String,
        val infoMessage: String) {

    val discountPercentage: Float = ((price.toFloat() / originalPrice) - 1) * 100
}
