import extensions.projectLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        dependencies {
            plugins.withId("com.android.base") {
                add("implementation", projectLibs.findBundle("koin").get())
            }
        }
    }
}