package com.example.erasmusplus;


import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import org.jetbrains.annotations.Contract;

public class FragmentLifecycleObserver implements LifecycleObserver{

    private String LOG_TAG = "FragmentLifecycleObserver";
    private Boolean isActive;


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onResume() {
        Log.i(LOG_TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void setTitle() {
        System.out.println("Event to change Title took place!!");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        Log.i(LOG_TAG,owner.getLifecycle().getCurrentState().name());

    }

    public boolean getFragmentState() {
        return isActive ;
    }

}




