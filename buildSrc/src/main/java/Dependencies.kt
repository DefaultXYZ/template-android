object ApplicationId {
    const val id = "io.sentizer.android"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
}

object Releases {
    const val versionMajor = 0
    const val versionMinor = 0
    const val buildNum = 1

    val versionCode = versionMajor * 1_000_000 + versionMinor * 1_000 + buildNum
    val versionName = "$versionMajor.$versionMinor.$buildNum"
}

object Versions {
    const val gradle = "3.5.2"
    const val kotlin = "1.3.60"
    const val googleServices = "4.3.2"
    const val fabric = "1.31.0"
    const val dependencyUpdates = "0.25.0"

    const val compileSdk = 28
    const val minSdk = 21
    const val targetSdk = 28

    const val appcompat = "1.1.0"
    const val ktx = "1.1.0"
    const val constraintlayout = "1.1.3"
    const val recyclerview = "1.0.0"

    const val lifecycle = "2.1.0"
    const val legacySupport = "1.0.0"

    const val room = "2.2.0-beta01"

    const val firebaseCore = "17.2.0"
    const val firebaseAuth = "19.1.0"

    const val facebookLogin = "5.0.1"
    const val googleAuth = "17.0.0"

    const val crashlytics = "2.10.1"

    const val retrofit = "2.6.2"

    const val rxjava = "2.2.13"
    const val rxandroid = "2.1.1"
    const val rxkotlin = "2.4.0"

    const val rxwifi = "0.3.0"

    const val dexter = "5.0.0"

    const val spinKit = "1.2.0"
    const val cardStackView = "2.3.3"
    const val materialRatingBar = "1.3.3"
    const val countryCodePicker = "2.3.4"

    const val glide = "4.10.0"

    const val dagger = "2.16"

    const val leakCanary = "2.0-beta-3"

    const val junit = "4.12"
    const val testCore = "1.2.0"
    const val mockitoKotlin = "2.1.0"

    const val testRunner = "1.2.0"
    const val espresso = "3.2.0"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomRxJava = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"

    const val facebookLogin = "com.facebook.android:facebook-login:${Versions.facebookLogin}"
    const val googleAuth = "com.google.android.gms:play-services-auth:${Versions.googleAuth}"

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    const val rxwifi = "com.github.pwittchen:reactivewifi-rx2:${Versions.rxwifi}"
    const val dexter = "com.karumi:dexter:${Versions.dexter}"
    const val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinKit}"
    const val cardStackView = "com.yuyakaido.android:card-stack-view:${Versions.cardStackView}"
    const val materialRatingBar =
        "me.zhanghai.android.materialratingbar:library:${Versions.materialRatingBar}"
    const val countryCodePicker = "com.hbb20:ccp:${Versions.countryCodePicker}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val daggerCompilerTest = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val junit = "junit:junit:${Versions.junit}"
    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    const val roomTest = "androidx.room:room-testing:${Versions.room}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}