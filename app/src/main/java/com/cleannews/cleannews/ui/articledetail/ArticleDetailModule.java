package com.cleannews.cleannews.ui.articledetail;

import com.cleannews.cleannews.ui.articlelist.domain.model.Article;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lucas on 10/4/17.
 */

@Module
public abstract class ArticleDetailModule {

    @ContributesAndroidInjector
    abstract ArticleDetailFragment articleDetailFragment();

    @Provides
    static Article provideArticle(ArticleDetailActivity activity) {
        return activity.getIntent().getParcelableExtra(ArticleDetailActivity.EXTRA_ARTICLE);
    }
}