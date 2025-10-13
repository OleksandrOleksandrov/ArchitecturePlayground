package com.oleksandr.network

object HttpRoutes {

    private const val NASA_BASE_URL = BuildConfig.NASA_BASE_URL

    // Auth region
    // TODO replace with dynamic api_key
    const val EPIC_PICTURE_LIST = "https://epic.gsfc.nasa.gov/api/natural?api_key=3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu"
    // APOD - Astronomy Picture of the Day
    // TODO replace with dynamic api_key
    const val APOD = "$NASA_BASE_URL/planetary/apod?api_key=3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu"
    // Auth endregion

    private fun String.urlPath() = this.removePrefix(NASA_BASE_URL)

}