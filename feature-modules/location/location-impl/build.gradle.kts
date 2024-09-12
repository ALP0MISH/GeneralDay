plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.general.location.impl"
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
    implementation(projects.featureModules.location.locationApi)
    implementation(projects.core)
    implementation(projects.uiCore)

    /** Dagger **/
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    /** Coroutines **/
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /** Location Services **/
    implementation(libs.services.location)
}