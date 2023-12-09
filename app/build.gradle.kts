import java.io.FileInputStream
import java.lang.System.load
import java.util.Properties

plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.androidx.navigation.safeargs)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.com.google.devtools.ksp)
    alias(libs.plugins.com.google.services)
    alias(libs.plugins.com.google.firebase.crashlytics)
    id("kotlin-parcelize")
}



val properties = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "config\\gelecekbilimde-config.properties")))
}

hilt {
    enableAggregatingTask = true
}
android {
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileSdk = 34
    namespace = "org.gelecekbilimde"
    defaultConfig {
        applicationId = "com.teyyihan.gelecekbilimde"
        minSdk = 21
        targetSdk = 33
        versionCode = 11
        versionName = "2.2.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        /** Secret Properties**/
        buildConfigField("String", "BASE_URL", "\"${properties.getProperty("BASE_URL")}\"")
        buildConfigField("String", "YOUTUBE_API", "\"${properties.getProperty("YOUTUBE_API")}\"")
        buildConfigField("String", "YOUTUBE_API_KEY", "\"${properties.getProperty("YOUTUBE_API_KEY")}\"")
        buildConfigField("String", "CHANNEL_ID", "\"${properties.getProperty("CHANNEL_ID")}\"")
        buildConfigField("String", "PLAYLIST_ID", "\"${properties.getProperty("PLAYLIST_ID")}\"")
        /**Secret Properties**/


    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}
dependencies {

    // Kotlin
    implementation(libs.kotlin.stdlib)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)

    // Material Design
    implementation(libs.material)
    implementation(libs.androidx.viewpager2)

    // ConstraintLayout
    implementation(libs.constraintlayout)

    // Legacy Support Library
    implementation(libs.androidx.legacy.support.v4)

    // Multidex
    implementation(libs.androidx.multidex)

    // DeSugar Use Java 8 language features and APIs
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    // Dagger Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // Room
    implementation(libs.room)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle Scopes
    implementation(libs.lifecycle)
    implementation(libs.lifecycle.runtime)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // Navigation
    implementation(libs.navigation)
    implementation(libs.navigation.ui)

    // Glide
    implementation(libs.glide)
    ksp(libs.ksp)


    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.config)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.inappmessaging)
    implementation(libs.app.update.ktx)
    // implementation(libs.user.messaging.platform)

    implementation(project(":smoothbottombar"))

    //Video Player
    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.0.0")

}