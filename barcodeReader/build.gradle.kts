import config.AppConfig
import config.libraryConfig
import dependencies.libs.*

plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    libraryConfig(AppConfig.libraryConfig)

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeLibs.VERSION_COMPOSE
        kotlinCompilerVersion = KotlinLibs.VERSION_KOTLIN
    }
    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementations(AndroidLibs.dependencies())
    implementations(CameraLibs.dependencies())
    implementations(ComposeLibs.dependencies())
    implementations(CustomLibs.dependencies())
    implementations(KotlinLibs.dependencies())

    apis(QrReaderLibs.dependencies())
}