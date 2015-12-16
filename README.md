# Google-analytics-example

### Add permissions to your project manifest

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

### Add plugin and dependency with Gradle

```xml
classpath 'com.google.gms:google-services:1.5.0-beta2'
```

```xml
apply plugin: 'com.google.gms.google-services'
```

```xml
compile 'com.google.android.gms:play-services-analytics:8.3.0'
```

### Go to this [link](https://developers.google.com/analytics/devguides/collection/android/v4/?csw=1) and find GET A CONFIGURATION FILE, follow the steps and create your app for google analytics

### Add class that extends Activity

```java
public class MyApplication extends Application {
private static MyApplication sInstance;
private static Tracker mTracker = null;
@Override
public void onCreate() {
    super.onCreate();
    sInstance = this;
}
synchronized static public Tracker getTracker() {
    if (mTracker == null) {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(sInstance);
        mTracker = analytics.newTracker(/*YOUT TRACKER ID*/);
        mTracker.enableAutoActivityTracking(false);
    }
    return mTracker;
}
}
```

### Example how to send screen and event
```java
MyApplication.getTracker().send(new HitBuilders.EventBuilder().setCategory(/*category*/).setAction(/*action*/).setLabel(/*label*/).build());
MyApplication.getTracker().setScreenName(/*screenName*/);
MyApplication.getTracker().send(new HitBuilders.ScreenViewBuilder().build());
```

### Example How to send screen and events with customDimensions
```java
MyApplication.getTracker().send(new HitBuilders.EventBuilder().setCategory(/*category*/).setAction(/*action*/).setLabel(/*label*/)
        .setCustomDimension(/*dimension id*/,/*value of custom dimension*/).build());
MyApplication.getTracker().setScreenName(/*screenName*/);
MyApplication.getTracker().send(new HitBuilders.ScreenViewBuilder().setCustomDimension(/*dimension id*/,/*value of custom dimension*/).build());
```