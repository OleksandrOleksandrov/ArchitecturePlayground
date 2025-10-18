import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.koin.conventions)

    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.oleksandr.network"
    compileSdk = libs.versions.app.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.app.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    val properties = Properties().also {
        it.load(
            FileInputStream(
                File(
                    project.rootDir,
                    "./configure/secrets/secrets.properties",
                )
            )
        )
    }
    val nasaApiKey = properties.getProperty("NASA_API_KEY")
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "NASA_BASE_URL", "\"https://api.nasa.gov\"")
            buildConfigField("String", "NASA_API_KEY", "\"$nasaApiKey\"")
        }
        getByName("debug") {
            buildConfigField("Boolean", "DEV_OPTIONS", "true")
            buildConfigField("String", "NASA_BASE_URL", "\"https://api.nasa.gov\"")
            buildConfigField("String", "NASA_API_KEY", "\"$nasaApiKey\"")
        }
        create("staging") {
            buildConfigField("Boolean", "DEV_OPTIONS", "true")
            buildConfigField("String", "NASA_BASE_URL", "\"https://api.nasa.gov\"")
            buildConfigField("String", "NASA_API_KEY", "\"$nasaApiKey\"")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.bundles.ktor)
    implementation(libs.androidx.core.ktx)
    implementation(project(":common-core"))
    implementation(project(":common-exception"))
}