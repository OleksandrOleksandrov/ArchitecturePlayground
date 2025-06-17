
import extensions.projectLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * A plugin for configuring Android test projects.
 *
 * This plugin is intended to set up configurations and dependencies specific to
 * Android test projects. As it currently stands, it does not apply any plugins
 * or configurations, but it serves as a placeholder for future test-related setups.
 *
 * Usage:
 *
 * ```kotlin
 * plugins {
 *     id("dev.devlight.skeleton.convention.test.android")
 * }
 * ```
 *
 * @see KotlinTestConventionPlugin
 */
// TODO: change kdoc and add logic
@Suppress("unused", "KDocUnresolvedReference")
class AndroidTestConventionPlugin : Plugin<Project> {

    /**
     * Applies the plugin to the given target project.
     *
     * Configures the project with necessary test-related settings and dependencies
     * for Android instrumentation and unit testing.
     *
     * @param target The target project to which the plugin is applied.
     */
    override fun apply(target: Project) {
//        jdk.tools.jlink.resources.plugins {
//            +"dev.devlight.skeleton.convention.di"
//        }

//        target.plugins {
//            +"dev.devlight.skeleton.convention.di"
//        }

        target.tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
            }
        }

        target.extensions.configure<com.android.build.gradle.LibraryExtension> {
            testOptions {
                unitTests.isIncludeAndroidResources = true
            }

            defaultConfig {
                testInstrumentationRunner = "de.mannodermaus.junit5.AndroidJUnit5Builder"
                testInstrumentationRunnerArguments["runnerBuilder"] = "de.mannodermaus.junit5.AndroidJUnit5Builder"
            }
        }

        target.tasks.withType<Test> {
            useJUnitPlatform()
        }

        with(target.projectLibs) {
            target.dependencies {
//                implementTestDependency(versionCatalog = target.projectLibs, value = "junit")
//                implementTestDependency(versionCatalog = target.projectLibs, value = "truth")

                // Android-specific testing dependencies
//                implementAndroidTestDependency("robolectric")
//                implementAndroidTestDependency("junit")
            }
        }
    }
}
