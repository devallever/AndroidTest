plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.androidunittest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidunittest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        //设置插桩测试运行程序
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file("../androidtest.jks")
            storePassword = "androidtest"
            keyAlias = "androidtest"
            keyPassword = "androidtest"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

//    testImplementation(libs.junit)

    // Required -- JUnit 4 framework
    testImplementation("junit:junit:4.13.2")
    // Optional -- Robolectric environment
    testImplementation ("androidx.test:core:1.6.1")
    // Optional -- Mockito framework
    testImplementation ("org.mockito:mockito-core:2.28.2")
    // Optional -- mockito-kotlin
    testImplementation ("org.mockito.kotlin:mockito-kotlin:2.2.11")
    // Optional -- Mockk framework
    testImplementation("io.mockk:mockk:1.12.1")

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.test:runner:1.6.1")
    androidTestImplementation("androidx.test:rules:1.6.1")
}