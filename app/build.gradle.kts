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
    implementation(project(":domain-epic"))
    implementation(project(":data-epic"))
}