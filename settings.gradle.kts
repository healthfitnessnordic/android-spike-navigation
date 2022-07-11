enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "sats-navigation-spike"

include(":app")

include(":core:navigation")

include(":features:book")
include(":features:check-in")
include(":features:clubs")
include(":features:home")
include(":features:profile")
