plugins {
    alias(libs.plugins.android.koin.conventions)

    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.ksp)
}

android {
    namespace = "com.oleksandr.data.database.impl"
    compileSdk = libs.versions.app.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.app.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    //region third-party
    //region room
    implementation(libs.room.common)
    implementation(libs.room.core)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    //endregion room
    //endregion third-party
    //region modules
    implementation(project(":data-database"))
    //endregion modules
}