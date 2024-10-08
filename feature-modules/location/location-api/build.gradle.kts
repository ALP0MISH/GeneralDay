plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "com.example.general.day.location.api"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(projects.core)
}