plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(App.compile)
    defaultConfig {
        applicationId = App.id
        minSdkVersion(App.min)
        targetSdkVersion(App.target)
        versionCode = App.code
        versionName = App.name
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.recyclerView)
    implementation(Libraries.material)
    implementation(Libraries.glide)
    implementation(Libraries.cicerone)
    implementation(Libraries.circleImage)
    implementation(Libraries.rxAndroid)
    implementation(Libraries.cardView)

    implementation(Libraries.timber)
    implementation(Libraries.okHttpLog)

    implementation(Libraries.moxy)
    implementation(Libraries.moxyAppCompat)

    implementation(Libraries.dagger)
    implementation(Libraries.daggerAndroid)

    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGson)
    implementation(Libraries.retrofitRxJava)

    kapt(Libraries.glideCompiler)
    kapt(Libraries.moxyCompiler)
    kapt(Libraries.daggerCompiler)
    kapt(Libraries.daggerAndroidKapt)
}

repositories {
    mavenCentral()
}
