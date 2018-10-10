package com.cleannews.cleannews.data.api;

import android.content.Context;

import com.cleannews.cleannews.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lucas on 9/1/17.
 */

@Module
public class ApiServiceModule {

    private static final String BASE_URL = BuildConfig.SERVER_URL;

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory,
                             OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideRxJavaAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(HttpLoggingInterceptor httpLoginInterceptor,
                                   PublicKeyInterceptor publicKeyInterceptor,
                                   ConnectivityInterceptor connectivityInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(httpLoginInterceptor)
                .addInterceptor(publicKeyInterceptor)
                .build();
    }

    @Provides
    @Singleton
    PublicKeyInterceptor providePublicKeyInterceptor() {
        return new PublicKeyInterceptor();
    }

    @Provides
    @Singleton
    ConnectivityInterceptor provideConnectivityInterceptor(Context context) {
        return new ConnectivityInterceptor(context);
    }

    /* Specific services */
    @Provides
    @Singleton
    SourceArticleService provideSourceArticleService(Retrofit retrofit) {
        return retrofit.create(SourceArticleService.class);
    }
}
