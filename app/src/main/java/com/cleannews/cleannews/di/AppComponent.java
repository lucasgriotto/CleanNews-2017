package com.cleannews.cleannews.di;

import android.app.Application;

import com.cleannews.cleannews.CleanNewsApplication;
import com.cleannews.cleannews.data.api.ApiServiceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by lucas on 8/31/17.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        ApiServiceModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(CleanNewsApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
