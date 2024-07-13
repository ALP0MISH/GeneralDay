plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.android.google.map)
}

android {
    namespace = "com.example.general.day.map.impl"
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
    implementation(projects.core)
    implementation(projects.uiCore)
    implementation(projects.domain)
    implementation(projects.uiComponents)
    implementation(projects.featureModules.favorite.favoriteApi)

    /** Navigation **/
    implementation(libs.navigation.compose)

    /** Immutable collections **/
    implementation(libs.kotlinx.collections.immutable)

    /** Coroutines **/
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /** Dagger **/
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    /** Google maps **/
    implementation(libs.play.services.maps)
    implementation(libs.services.location)
    /** Google maps Utility **/
    implementation(libs.maps.ktx)
    implementation(libs.maps.utils.ktx)
    /** Google maps for compose **/
    implementation(libs.maps.compose)

    /** Compose **/
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    androidTestImplementation(libs.androidx.compose.ui.test)
}