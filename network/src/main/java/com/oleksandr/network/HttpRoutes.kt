package com.oleksandr.network

object HttpRoutes {

    const val NASA_BASE_URL = BuildConfig.NASA_BASE_URL

    // Auth region
    const val TEST = "$NASA_BASE_URL/DONKI/CME?startDate=2017-01-03&endDate=2017-01-03&api_key=DEMO_KEY"
    // Auth endregion

    private fun String.urlPath() = this.removePrefix(NASA_BASE_URL)

}