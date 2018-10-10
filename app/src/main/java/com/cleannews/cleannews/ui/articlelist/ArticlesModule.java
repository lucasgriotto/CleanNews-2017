package com.cleannews.cleannews.ui.articlelist;

import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lucas on 10/4/17.
 */

@Module
public abstract class ArticlesModule {

    @ContributesAndroidInjector
    abstract ArticlesFragment articlesFragment();

    @Provides
    static Source provideSource(ArticlesActivity activity) {
        return activity.getIntent().getParcelableExtra(ArticlesActivity.EXTRA_SOURCE);
    }
}