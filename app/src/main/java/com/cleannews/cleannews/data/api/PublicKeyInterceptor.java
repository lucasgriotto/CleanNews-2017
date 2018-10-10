package com.cleannews.cleannews.data.api;

import com.cleannews.cleannews.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lucas on 10/3/17.
 */

public class PublicKeyInterceptor implements Interceptor {

    private static final String PUBLIC_KEY = BuildConfig.API_KEY;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("apiKey", PUBLIC_KEY)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
