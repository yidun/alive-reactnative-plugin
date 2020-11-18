# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/Cellar/android-sdk/24.3.3/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:
-keep class com.netease.nis.alivedetected.entity.**{*;}
-keep class com.netease.nis.alivedetected.AliveDetector  {#不会混淆类名
    public <methods>;
}
-keep class com.netease.nis.alivedetected.DetectedEngine{
    native <methods>;
}
-keep class com.netease.nis.alivedetected.NISCameraPreview  {#不会混淆类名
    public <methods>;
}
-keep class com.netease.nis.alivedetected.DetectedListener{*;}
-keep class com.netease.nis.alivedetected.ActionType  { *;}