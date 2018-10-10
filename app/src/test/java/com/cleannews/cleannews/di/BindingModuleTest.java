package com.cleannews.cleannews.di;

import com.cleannews.cleannews.SourcesActivityTest;
import com.cleannews.cleannews.data.api.ApiServiceModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lucas on 10/11/2017.
 */

@Module
public abstract class BindingModuleTest {

    @ContributesAndroidInjector(modules = ApiServiceModule.class)
    abstract SourcesActivityTest sourcesActivityTest();

}
