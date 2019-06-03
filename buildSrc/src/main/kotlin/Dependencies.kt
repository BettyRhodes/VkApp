const val kotlinVersion = "1.3.31"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.4.1"
    }

    const val androidGradlePlugin     = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin      = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication      = "com.android.application"
    const val kotlinAndroid           = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt              = "kotlin-kapt"
}

object App {
    const val min     = 21
    const val compile = 28
    const val target  = compile
    const val id      = "com.example.vkapi"
    const val name    = "1.0.0"
    const val code    = 1
}

object Libraries {
    private object Versions {
        const val jetpack          = "1.0.2"
        const val ktx              = "1.0.1"
        const val constraintLayout = "1.1.3"
        const val circle           = "3.0.0"
        const val card             = "28.0.0"
        const val recyclerView     = "1.0.0"
        const val material         = "1.0.0"
        const val cicerone         = "5.0.0"
        const val glide            = "4.9.0"
        const val moxy             = "1.5.5"
        const val dagger           = "2.22.1"
        const val retrofit         = "2.5.0"
        const val rxJava           = "2.1.1"
        const val timber           = "4.7.1"
        const val okHttp           = "3.14.2"
    }

    const val kotlinStdLib     = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val appCompat        = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val ktxCore          = "androidx.core:core-ktx:${Versions.ktx}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView     = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val material         = "com.google.android.material:material:${Versions.material}"
    const val cardView         = "com.android.support:cardview-v7:${Versions.card}"
    const val circleImage      = "de.hdodenhof:circleimageview:${Versions.circle}"

    const val cicerone         = "ru.terrakok.cicerone:cicerone:${Versions.cicerone}"

    const val rxAndroid        = "io.reactivex.rxjava2:rxandroid:${Versions.rxJava}"

    const val timber           = "com.jakewharton.timber:timber:${Versions.timber}"
    const val okHttpLog        = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val glide         = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val moxy          = "com.arello-mobile:moxy:${Versions.moxy}"
    const val moxyAppCompat = "com.arello-mobile:moxy-app-compat:${Versions.moxy}"
    const val moxyCompiler  = "com.arello-mobile:moxy-compiler:${Versions.moxy}"

    const val dagger            = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler    = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid     = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidKapt = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    const val retrofit       = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson   = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
}