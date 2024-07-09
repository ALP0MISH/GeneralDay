pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "General-Day"
include(
    ":app",
    ":data",
    ":domain",
    ":core",
    ":ui-core",
    ":feature-modules",
    ":feature-modules:home:home-api",
    ":feature-modules:home:home-impl",
    ":feature-modules:favorite:favorite-api",
    ":feature-modules:favorite:favorite-impl",
)