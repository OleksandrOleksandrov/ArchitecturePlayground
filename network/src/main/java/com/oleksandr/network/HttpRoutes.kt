package com.oleksandr.network

object HttpRoutes {

    private const val NASA_BASE_URL = BuildConfig.NASA_BASE_URL

    private const val API_KEY = BuildConfig.NASA_API_KEY

    // Auth region
    const val EPIC_PICTURE_LIST = "https://epic.gsfc.nasa.gov/api/natural?api_key=$API_KEY"
    // APOD - Astronomy Picture of the Day
    const val APOD = "$NASA_BASE_URL/planetary/apod?api_key=$API_KEY"
    // Auth endregion

    private fun String.urlPath() = this.removePrefix(NASA_BASE_URL)

}