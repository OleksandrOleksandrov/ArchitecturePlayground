package extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * Name libs instead of projectLibs can not be applied because of conflict.
 * If name is libs then this structure "implementation(libs.androidx.core.ktx)" will not work.
 */
val Project.projectLibs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")