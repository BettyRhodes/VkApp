package com.example.vkapi.dagger

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MockQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LiveQualifier