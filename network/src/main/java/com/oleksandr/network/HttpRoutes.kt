package com.oleksandr.network

object HttpRoutes {

    private const val NASA_BASE_URL = BuildConfig.NASA_BASE_URL

    // Auth region
    const val EPIC_PICTURES = "$NASA_BASE_URL/EPIC/api/natural?api_key=DEMO_KEY"
    // Auth endregion

    private fun String.urlPath() = this.removePrefix(NASA_BASE_URL)

}