package com.example.erasmusplus;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class SecondFragmentLifecycleObserver implements LifecycleObserver {

    private String LOG_TAG = "SecondFrgamentLifecycleObserver";



    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        Log.i(LOG_TAG,owner.getLifecycle().getCurrentState().name());

        }
}
