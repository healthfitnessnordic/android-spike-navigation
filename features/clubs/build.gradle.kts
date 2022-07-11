plugins {
  id("com.android.library")

  kotlin("android")
  kotlin("kapt")

  id("dagger.hilt.android.plugin")
}

android {
  namespace = "com.sats.spikes.navigation.features.clubs"

  compileSdk = 32

  defaultConfig {
    minSdk = 24
  }

  buildFeatures {
    buildConfig = false
    compose = true
  }

  buildTypes {
    debug {}
    release {}
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

  // AndroidX
  implementation(libs.androidx.compose.animation)
  implementation(libs.androidx.compose.foundation)
  implementation(libs.androidx.compose.material.icons)
  implementation(libs.androidx.compose.material.material)
  implementation(libs.androidx.compose.runtime.runtime)
  implementation(libs.androidx.compose.ui.tooling)
  implementation(libs.androidx.compose.ui.ui)
  implementation(libs.androidx.lifecycle.viewModel)
  implementation(libs.androidx.lifecycle.viewModelCompose)
  kapt(libs.androidx.hilt.compiler)

  // Dagger Hilt
  implementation(libs.dagger.hilt.runtime)
  kapt(libs.dagger.hilt.compiler)

  // Kotlin
  implementation(libs.kotlin.stdLib)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.kotlinx.coroutines.core)
}
