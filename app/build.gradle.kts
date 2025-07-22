plugins {
    alias(libs.plugins.android.app.module.conventions)
    alias(libs.plugins.android.koin.conventions)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.oleksandr.architectureplayground"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(project(":network"))
    implementation(project(":data-database"))
    implementation(project(":data-database:impl"))
    implementation(project(":core-navigation"))
    implementation(project(":common-kotlin"))
    implementation(project(":common-mapper"))
    implementation(project(":feature-earth-polychromatic-imaging-camera"))
    implementation(project(":feature-epic-details"))
    implementation(project(":presentation-core-model"))
    implementation(project(":presentation-core-platform"))
    implementation(project(":presentation-core-styling"))
    implementation(project(":domain-epic"))
    implementation(project(":domain-picture-of-day"))
    implementation(project(":data-epic"))
    implementation(project(":data-astronomy-picture-of-day"))
    implementation(project(":data-preference"))
    implementation(project(":data-preference:impl"))
}