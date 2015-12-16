package com.example.android_srbija.ganalytics;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import rs.golive.fappexxx.MyClasses.Analytics;

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
            mTracker = analytics.newTracker(/*YOUR TRACKER ID*/);
            mTracker.enableAutoActivityTracking(false);// i prefer to set this false and create custom screens,
            // if your set this true it will send screens on auto
        }

        return mTracker;
    }
}