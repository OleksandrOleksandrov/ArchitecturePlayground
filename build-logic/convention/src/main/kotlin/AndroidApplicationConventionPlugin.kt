import com.android.build.api.dsl.ApplicationExtension
import extensions.configureKotlinAndroid
import extensions.projectLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.applicationId = "com.oleksandr.architectureplayground"
                defaultConfig.targetSdk = projectLibs.findVersion("app-targetSdk").get().displayName.toInt()

                defaultConfig.versionCode = 1
                defaultConfig.versionName = "1.0"
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
    }
}

