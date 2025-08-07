plugins {
    alias(libs.plugins.android.koin.conventions)

    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.oleksandr.earth.polychromatic.imaging.camera"
    compileSdk = libs.versions.app.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.app.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.material3)
    implementation(libs.coil)
    implementation(libs.androidx.navigation.compose)
    implementation(project(":common-core"))
    implementation(project(":core-navigation"))
    implementation(project(":presentation-core-platform"))
    implementation(project(":presentation-core-styling"))
    implementation(project(":common-kotlin"))
    implementation(project(":common-mapper"))
    implementation(project(":domain-epic"))
    implementation(project(":domain-picture-of-day"))
    implementation(project(":presentation-core-model"))
    implementation(project(":feature-epic-details"))
    implementation(libs.androidx.ui.tooling.preview)

    //region Adaptive layout
    implementation(libs.androidx.adaptive)
    implementation(libs.androidx.material3.window.sizeclass)
    implementation(libs.androidx.adaptive.layout)
    implementation(libs.androidx.adaptive.navigation)
    implementation(libs.androidx.material3.adaptive.navigation.suite)
    //endregion Adaptive layout
}