import com.android.build.api.dsl.ApplicationExtension
import extensions.app
import extensions.configureKotlinAndroid
import extensions.plugins
import extensions.projectLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.kotlin.dsl.withType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            target.plugins {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.applicationId = "com.oleksandr.architectureplayground"
                defaultConfig.targetSdk = projectLibs.findVersion("app-targetSdk").get().displayName.toInt()
                defaultConfig.minSdk = projectLibs.findVersion("app-minSdk").get().displayName.toInt()

                defaultConfig.versionCode = 1
                defaultConfig.versionName = "1.0"
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
        // Necessary for context receiver
//        target.tasks.withType<KotlinCompile>().configureEach {
//            compilerOptions {
//                freeCompilerArgs.add("-Xcontext-receivers")
//            }
//        }
    }
}

