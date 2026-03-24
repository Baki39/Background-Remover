# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep line numbers for better crash reports
-keepattributes SourceFile,LineNumberTable

# Firebase
-keep class com.google.firebase.** { *; }

# AdMob
-keep class com.google.android.gms.ads.** { *; }

# ML Kit
-keep class com.google.mlkit.** { *; }

# Kotlin Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

# Compose
-dontwarn androidx.compose.**