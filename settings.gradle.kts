pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ArchitecturePlayground"
include(":app")

// Common modules
include(":common-kotlin")
include(":common-mapper")
include(":common-domain")

include(":network")
include(":core-navigation")
include(":presentation-core-model")
include(":presentation-core-platform")
include(":presentation-core-styling")

// Data modules
include(":data-database")
include(":data-database:impl")

include(":data-preference")
include(":data-preference:impl")

include(":data-epic")
include(":data-astronomy-picture-of-day")

// Domain modules
include(":domain-epic")
include(":domain-picture-of-day")

// Feature modules
include(":feature-earth-polychromatic-imaging-camera")
include(":feature-epic-details")

