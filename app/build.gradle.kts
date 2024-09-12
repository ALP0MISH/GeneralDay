plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.general.day"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.general.day"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.core)
    implementation(projects.uiCore)
    implementation(projects.uiComponents)
    implementation(projects.featureModules.home.homeImpl)
    implementation(projects.featureModules.home.homeApi)
    implementation(projects.featureModules.favorite.favoriteApi)
    implementation(projects.featureModules.favorite.favoriteImpl)
    implementation(projects.featureModules.map.mapApi)
    implementation(projects.featureModules.map.mapImpl)
    implementation(projects.featureModules.location.locationApi)
    implementation(projects.featureModules.location.locationImpl)
    implementation(projects.featureModules.detail.detailApi)
    implementation(projects.featureModules.detail.detailImpl)

    /** Coroutines **/
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /** Dagger **/
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    /** Google maps Utility **/
    implementation(libs.maps.ktx)
    implementation(libs.maps.utils.ktx)
    implementation(libs.maps.utils)
    /** Google maps for compose **/
    implementation(libs.maps.compose)
    implementation(libs.androidx.appcompat)

    /** Room **/
    kapt(libs.room.compiler)
    kapt(libs.room.ktx.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    /** Retrofit **/
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.gson)

    /** Navigation **/
    implementation(libs.navigation.compose)

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