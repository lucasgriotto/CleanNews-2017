package com.cleannews.cleannews.di;

import android.app.Application;
import android.content.Context;

import com.cleannews.cleannews.data.repository.SourceArticleDataSource;
import com.cleannews.cleannews.data.repository.remote.SourceArticleRemoteDataSource;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lucas on 8/31/17.
 */

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Named("remote")
    @Singleton
    static SourceArticleDataSource provideArticleRemoteDataSource(SourceArticleRemoteDataSource articleRemoteDataSource) {
        return articleRemoteDataSource;
    }

    @Provides
    @Named("executor_thread")
    @Singleton
    static Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_thread")
    @Singleton
    static Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
