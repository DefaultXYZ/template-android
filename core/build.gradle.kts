plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures.dataBinding = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlin)

    implementation(Libraries.appcompat)
    implementation(Libraries.ktx)
    implementation(Libraries.recyclerview)

    implementation(Libraries.lifecycleExtensions)

    implementation(Libraries.rxjava)
    implementation(Libraries.rxkotlin)
    implementation(Libraries.rxandroid)

    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerAndroidSupport)

    api(Libraries.timber)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.testCore)
    testImplementation(Libraries.testRunner)
    testImplementation(Libraries.lifecycleTesting)
    testImplementation(Libraries.roomTest)
    testImplementation(Libraries.mockitoKotlin)

    androidTestImplementation(Libraries.testRunner)
    androidTestImplementation(Libraries.espresso)
}
