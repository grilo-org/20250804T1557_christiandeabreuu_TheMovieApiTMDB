plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.example.desafiodimensa"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.desafiodimensa"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(libs.testng)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Coil (para carregar imagens)
    implementation(libs.coil)

    // Navigation
    implementation(libs.navigationFragmentKtx)    // Fragment
    implementation(libs.navigationUiKtx)           // UI

    // Coroutines
    implementation(libs.coroutines.android)

    // Lifecycle (para ViewModel e LiveData)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // RecyclerView
    implementation(libs.recyclerview)

    //Koin
    implementation(libs.koin.android)
    implementation(libs.koin.android.compat)
    implementation(libs.koin.androidx.workmanager)

    // MockK para testes unitários
    testImplementation(libs.mockk)
    // MockK para testes instrumentados (Android)
    androidTestImplementation(libs.mockk.android)

    // Coroutines Test
    testImplementation(libs.kotlinx.coroutines.test)

    // Dependência para InstantTaskExecutorRule
    testImplementation(libs.androidx.arch.core.testing)

}