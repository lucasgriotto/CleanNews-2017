package com.cleannews.cleannews.di;

import android.content.Context;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by lucas on 10/11/2017.
 */

public class CleanNewsApplicationTest extends DaggerApplication {

    private static Context context;

    public CleanNewsApplicationTest() {
        this.context = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

    public static Context getContext() {
        return context;
    }

}

