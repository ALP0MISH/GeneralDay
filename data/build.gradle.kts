plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
}
android {
    namespace = "com.example.general.day.data"
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
    implementation(projects.domain)

    /** Coroutines **/
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /** Dagger **/
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    /** Room **/
    kapt(libs.room.compiler)
    kapt(libs.room.ktx.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    /** Retrofit **/
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
}