plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.general.day.core"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    /** Coroutines **/
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /** Dagger **/
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    /** Navigation **/
    implementation(libs.navigation.compose)
}