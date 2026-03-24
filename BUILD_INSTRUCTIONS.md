# AI Image Enhancer - Build Instructions

## Prerequisites

To build this Android app, you need:

1. **Java 17 or 21** - Java 25 is not yet supported by Gradle
2. **Android Studio** - Or command line tools
3. **Android SDK** - API 34

## Quick Start

### Option 1: Using Android Studio
1. Open Android Studio
2. File → Open → Select `ai-image-enhancer` folder
3. Wait for Gradle sync
4. Build → Build Bundle(s) / APK(s) → Build APK(s)

### Option 2: Command Line
```bash
# Install Java 17 (if not installed)
brew install openjdk@17

# Set JAVA_HOME
export JAVA_HOME=$(brew --prefix openjdk@17)/libexec/openjdk.jdk/Contents/Home

# Build debug APK
cd ai-image-enhancer
./gradlew assembleDebug
```

## Output

The debug APK will be at:
```
app/build/outputs/apk/debug/app-debug.apk
```

## Environment Variables Needed

Create a `local.properties` file with:
```properties
sdk.dir=/path/to/your/android/sdk
```

## Google Services

The app includes a placeholder `google-services.json`. Replace it with your own from Firebase Console for production.

## AdMob

Update the AdMob App ID in `AndroidManifest.xml`:
```xml
<meta-data
    android:name="com.google.android.gms.ads.APPLICATION_ID"
    android:value="ca-app-pub-YOUR-ID" />
```

## Store Assets Needed

Before publishing to Play Store, create:
- App Icon: 512x512 PNG
- Feature Graphic: 1024x500 PNG  
- Screenshots: 8 images (1080x1920)
- Privacy Policy URL
- Terms of Service URL

## Build Commands

```bash
# Debug APK
./gradlew assembleDebug

# Release APK (requires signing config)
./gradlew assembleRelease

# Clean
./gradlew clean
```

---

**Status:** Code generated, needs Java 17/21 to build