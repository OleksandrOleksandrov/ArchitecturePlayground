plugins {
    alias(libs.plugins.android.koin.conventions)

    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.oleksandr.earth.polychromatic.imaging.camera"
    compileSdk = libs.versions.app.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.app.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.material3)
    implementation(libs.coil)
    implementation(libs.androidx.navigation.compose)
    implementation(project(":core-navigation"))
    implementation(project(":common-kotlin"))
    implementation(project(":common-mapper"))
    implementation(project(":domain-epic"))
    implementation(project(":domain-picture-of-day"))
    implementation(project(":presentation-core-model"))
    implementation(project(":feature-epic-details"))

    //region Adaptive layout
    implementation(libs.androidx.adaptive)
    implementation(libs.androidx.material3.window.sizeclass)
    implementation(libs.androidx.adaptive.layout)
    implementation(libs.androidx.adaptive.navigation)
    implementation(libs.androidx.material3.adaptive.navigation.suite)
    //endregion Adaptive layout
}