package com.cleannews.cleannews.di;

import android.app.Application;

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
@Component(modules = {AppModule.class, BindingModuleTest.class, AndroidSupportInjectionModule.class, ApiServiceModule.class})
public interface AppComponentTest extends AndroidInjector<DaggerApplication> {

    void inject(CleanNewsApplicationTest application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponentTest.Builder application(Application application);

        AppComponentTest build();
    }

}
