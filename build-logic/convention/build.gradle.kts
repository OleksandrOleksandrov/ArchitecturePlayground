import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.oleksandr.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

dependencies {
    compileOnly(libs.gradle)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.oleksandr.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidKoin") {
            id = "com.oleksandr.android.koin"
            implementationClass = "KoinConventionPlugin"
        }

        register("androidTest") {
            id = "com.oleksandr.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }

        register("kotlinTest") {
            id = "com.oleksandr.kotlin.test"
            implementationClass = "KotlinTestConventionPlugin"
        }
    }
}

// Necessary for context receiver
//tasks.withType<KotlinCompile>().configureEach {
//    kotlinOptions {
//        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
//    }
//}