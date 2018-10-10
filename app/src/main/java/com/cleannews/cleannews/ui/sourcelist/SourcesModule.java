package com.cleannews.cleannews.ui.sourcelist;

import com.cleannews.cleannews.di.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lucas on 10/4/17.
 */

@Module
public abstract class SourcesModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SourcesFragment sourcesFragment();
}