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
include(":network")
include(":data-database")
include(":data-database:impl")
include(":core-navigation")
include(":common-kotlin")
include(":common-mapper")
include(":feature-earth-polychromatic-imaging-camera")
include(":feature-epic-details")
include(":presentation-core-model")
include(":domain-epic")
include(":domain-picture-of-day")
include(":data-epic")
include(":data-astronomy-picture-of-day")
include(":data-preference")
include(":data-preference:impl")
include(":presentation-core-platform")
