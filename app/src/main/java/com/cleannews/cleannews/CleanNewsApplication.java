package com.cleannews.cleannews;

import com.cleannews.cleannews.di.AppComponent;
import com.cleannews.cleannews.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by lucas on 8/31/17.
 */

public class CleanNewsApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
