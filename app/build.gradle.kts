plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = ApplicationId.id
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(BuildProps.STRING_TYPE, BuildProps.API_PROP, Properties.apiBaseUrl)
        }

        getByName(BuildType.DEBUG) {
            buildConfigField(BuildProps.STRING_TYPE, BuildProps.API_PROP, Properties.apiBaseUrl)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    androidExtensions {
        isExperimental = true
    }

    buildFeatures.dataBinding = true
}

dependencies {
    implementation(project(Modules.core))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlin)
    implementation(Libraries.legacySupport)

    implementation(Libraries.lifecycleExtensions)
    kapt(Libraries.lifecycleCompiler)

    implementation(Libraries.appcompat)
    implementation(Libraries.ktx)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.recyclerview)
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUi)
    implementation(Libraries.flexboxLayout)

    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomRxJava)
    kapt(Libraries.roomCompiler)

    implementation(Libraries.firebaseCore)
    implementation(Libraries.firebaseAuth)

    implementation(Libraries.facebookLogin)
    implementation(Libraries.googleAuth)
    implementation(Libraries.googleLocation)

    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGson)
    implementation(Libraries.retrofitRxJava)

    implementation(Libraries.rxjava)
    implementation(Libraries.rxkotlin)
    implementation(Libraries.rxandroid)

    implementation(Libraries.rxLocation)
    implementation(Libraries.rxwifi)

    implementation(Libraries.dexter)

    implementation(Libraries.jodaTime)

    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerAndroidSupport)
    kapt(Libraries.daggerCompiler)
    kapt(Libraries.daggerAndroidProcessor)

//    debugImplementation Libraries.leakCanary

    kaptTest(Libraries.daggerCompilerTest)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.testCore)
    testImplementation(Libraries.testRunner)
    testImplementation(Libraries.lifecycleTesting)
    testImplementation(Libraries.roomTest)
    testImplementation(Libraries.mockitoKotlin)

    androidTestImplementation(Libraries.testRunner)
    androidTestImplementation(Libraries.espresso)
}
