plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "com.example.general.day.domain"
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

    /** Coroutines **/
    implementation(libs.kotlinx.coroutines.core)

    /** Dagger **/
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}