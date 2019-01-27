package com.johnnym.recyclerviewanimations.travelino

class TravelinoMockFactory {

    companion object {

        private const val UNSPLASH_BASE_URL = "https://source.unsplash.com/"

        fun createUnsplashImageUrl(photoId: String) = UNSPLASH_BASE_URL + photoId

        val Paris = TravelinoItem(
                "id_00",
                "Paris's Best Kept Secrets",
                52,
                74,
                createUnsplashImageUrl("Q0-fOL2nqZc"),
                "")

        val NewYork = TravelinoItem(
                "id_01",
                "Best New York Panoramas",
                60,
                95,
                createUnsplashImageUrl("UExx0KnnkjY"),
                "")

        val Zagreb = TravelinoItem(
                "id_02",
                "Explore Zagreb with a Local",
                70,
                92,
                createUnsplashImageUrl("ZINC3joF-JQ"),
                "")

        val London = TravelinoItem(
                "id_03",
                "Unseen London by Bicycle",
                30,
                35,
                createUnsplashImageUrl("tZDtyUrYrFU"),
                "")

        val Sidney = TravelinoItem(
                "id_04",
                "Visit Sidney Opera House",
                102,
                134,
                createUnsplashImageUrl("DLbCETd599Y"),
                "")

        val Berlin = TravelinoItem(
                "id_05",
                "World War II Tour in Berlin",
                48,
                64,
                createUnsplashImageUrl("fv0yV5-Pbjc"),
                "")

        val Rome = TravelinoItem(
                "id_06",
                "Tour around Rome in Fiat 500",
                42,
                48,
                createUnsplashImageUrl("0Bs3et8FYyg"),
                "")

        val Havana = TravelinoItem(
                "id_07",
                "Learn Salsa in a Havana!",
                99,
                113,
                createUnsplashImageUrl("RqMIFcDLeos"),
                "")
    }
}
