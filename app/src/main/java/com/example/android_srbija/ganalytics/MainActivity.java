package com.example.android_srbija.ganalytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this is example how to send event
        MyApplication.getTracker().send(new HitBuilders.EventBuilder().setCategory(/*category*/).setAction(/*action*/).setLabel(/*label*/).build());

        // first you need to set screen name then you send screen
        MyApplication.getTracker().setScreenName(/*screenName*/);
        MyApplication.getTracker().send(new HitBuilders.ScreenViewBuilder().build());

        // examples how to send screen and event with custom dimension
        // you need to create custom dimension in your google analytics app and then you put dimension id and its value with event or screen
        MyApplication.getTracker().send(new HitBuilders.EventBuilder().setCategory(/*category*/).setAction(/*action*/).setLabel(/*label*/)
                .setCustomDimension(/*dimension id*/,/*value of custom dimension*/).build());

        MyApplication.getTracker().setScreenName(/*screenName*/);
        MyApplication.getTracker().send(new HitBuilders.ScreenViewBuilder().setCustomDimension(/*dimension id*/,/*value of custom dimension*/).build());
    }
}
