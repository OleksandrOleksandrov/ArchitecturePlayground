package com.oleksandr.network

object HttpRoutes {

    private const val NASA_BASE_URL = BuildConfig.NASA_BASE_URL

    // Auth region
    const val EPIC_PICTURE_LIST = "$NASA_BASE_URL/EPIC/api/natural?api_key=3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu"
    // Auth endregion

    private fun String.urlPath() = this.removePrefix(NASA_BASE_URL)

}