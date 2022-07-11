plugins {
  id("com.android.application")

  kotlin("android")
  kotlin("kapt")

  id("dagger.hilt.android.plugin")
}

android {
  namespace = "com.sats.spikes.navigation.app"

  compileSdk = 32

  defaultConfig {
    minSdk = 24
    targetSdk = 32

    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    debug {
      isMinifyEnabled = false
    }

    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    compose = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
  }

  kapt.correctErrorTypes = true

  kotlinOptions {
    jvmTarget = "1.8"
  }

  packagingOptions {
    resources.excludes.add("META-INF/**/*")
  }
}

dependencies {
  // Accompanist
  implementation(libs.accompanist.insetsUi)
  implementation(libs.accompanist.navigation.animation)
  implementation(libs.accompanist.navigation.material)

  // AndroidX
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.animation)
  implementation(libs.androidx.compose.foundation)
  implementation(libs.androidx.compose.material.icons)
  implementation(libs.androidx.compose.material.material)
  implementation(libs.androidx.compose.runtime.runtime)
  implementation(libs.androidx.compose.ui.tooling)
  implementation(libs.androidx.compose.ui.ui)
  implementation(libs.androidx.hilt.navigation.compose)
  implementation(libs.androidx.lifecycle.viewModel)
  implementation(libs.androidx.lifecycle.viewModelCompose)
  implementation(libs.androidx.navigation.compose)
  kapt(libs.androidx.hilt.compiler)

  // Dagger Hilt
  implementation(libs.dagger.hilt.runtime)
  kapt(libs.dagger.hilt.compiler)

  // Material Design Components
  implementation(libs.google.material)

  // Kotlin
  implementation(libs.kotlin.stdLib)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.kotlinx.coroutines.core)
}
