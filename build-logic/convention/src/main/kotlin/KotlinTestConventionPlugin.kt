
import extensions.implementTestDependency
import extensions.implementTestRuntimeOnly
import extensions.projectLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

/**
 * Convention plugin for configuring unit tests in Kotlin projects.
 *
 * This plugin sets up common dependencies for unit testing in Kotlin projects
 * that do not involve Android-specific components. It adds dependencies for JUnit,
 * Mockito Core, and Mockito Kotlin to facilitate writing and running unit tests.
 *
 * Usage:
 *
 * ```kotlin
 * plugins {
 *     alias(libs.plugins.kotlin.test.conventions)
 * }
 * ```
 */
@Suppress("unused")
class KotlinTestConventionPlugin : Plugin<Project> {

    /**
     * Applies the plugin to the given target project.
     *
     * Configures the project with the following settings:
     * - Adds dependencies for unit testing:
     * - JUnit for writing and running tests.
     * - Mockito Core for creating mock objects.
     * - Mockito Kotlin for using Mockito with Kotlin features.
     *
     * @param target The target project to which the plugin is applied.
     */
    override fun apply(target: Project) = with(target) {
        //TODO add di when needed
//        target.plugins {
//            apply("dev.devlight.skeleton.convention.di")
//        }
        tasks.withType<Test> {
            useJUnitPlatform()
        }
        dependencies {
//            implementTestDependency(versionCatalog = target.projectLibs, value = "test.junit.api")
            implementTestRuntimeOnly(versionCatalog = target.projectLibs, value = "test.junit.jupiter")
//            implementTestRuntimeOnly(versionCatalog = target.projectLibs, value = "test.junit.engine")
//            implementTestDependency(versionCatalog = target.projectLibs, value = "test.junit.params")
//            implementTestDependency(versionCatalog = target.projectLibs, value = "mockito.core")
//            implementTestDependency(versionCatalog = target.projectLibs, value = "mockito.kotlin")
//            implementTestDependency(versionCatalog = target.projectLibs, value = "kotlinx.coroutines.test")
//            implementTestRuntimeOnly(versionCatalog = target.projectLibs, value = "test.junit.vintage")
            implementTestDependency(versionCatalog = target.projectLibs, value = "kotlin.test.junit5")
//            implementTestDependency(versionCatalog = target.projectLibs, value = "mockk")
//            implementTestDependency(versionCatalog = target.projectLibs, value = "turbine")
            implementTestDependency(versionCatalog = target.projectLibs, value = "truth")
        }
    }
}
