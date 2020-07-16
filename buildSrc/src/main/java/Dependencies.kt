object ApplicationId {
    const val id = "defaultxyz.template.android"
}

object Properties {
    const val apiBaseUrl = "\"<API_PATH>\""
}

object Modules {
    const val app = ":app"
    const val core = ":core"
}

object Releases {
    const val versionMajor = 0
    const val versionMinor = 0
    const val buildNum = 1

    const val versionCode = versionMajor * 1_000_000 + versionMinor * 1_000 + buildNum
    const val versionName = "$versionMajor.$versionMinor.$buildNum"
}

object BuildType {
    const val RELEASE = "release"
    const val DEBUG = "debug"
}

object BuildProps {
    const val STRING_TYPE = "String"

    const val API_PROP = "API_URL"
}

object Versions {
    const val gradle = "4.0.0"
    const val kotlin = "1.3.72"
    const val googleServices = "4.3.3"
    const val dependencyUpdates = "0.28.0"

    const val compileSdk = 28
    const val minSdk = 21
    const val targetSdk = 28
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val ktx = "androidx.core:core-ktx:1.3.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"

    const val navigationVersion = "2.2.2"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"

    const val flexboxLayout = "com.google.android:flexbox:2.0.1"

    private const val lifecycleVersion = "2.2.0"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"

    private const val roomVersion = "2.2.5"
    const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    const val roomRxJava = "androidx.room:room-rxjava2:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomTest = "androidx.room:room-testing:$roomVersion"

    const val firebaseCore = "com.google.firebase:firebase-core:17.4.2"
    const val firebaseAuth = "com.google.firebase:firebase-auth:19.3.1"

    const val facebookLogin = "com.facebook.android:facebook-login:7.0.0"
    const val googleAuth = "com.google.android.gms:play-services-auth:17.0.0"
    const val googleLocation = "com.google.android.gms:play-services-location:17.0.0"

    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

    const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.19"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    const val rxLocation = "com.patloew.rxlocation:rxlocation:1.0.5"
    const val rxwifi = "com.github.pwittchen:reactivewifi-rx2:0.3.0"

    const val dexter = "com.karumi:dexter:6.1.2"
    const val jodaTime = "joda-time:joda-time:2.10.6"

    private const val dagger = "2.28"
    const val daggerAndroid = "com.google.dagger:dagger-android:$dagger"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:$dagger"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$dagger"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:$dagger"
    const val daggerCompilerTest = "com.google.dagger:dagger-compiler:$dagger"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.1"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val junit = "androidx.test.ext:junit:1.1.1"
    const val testCore = "androidx.test:core:1.2.0"
    const val testRunner = "androidx.test:runner:1.2.0"
    const val lifecycleTesting = "androidx.arch.core:core-testing:2.1.0"
    const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
}
