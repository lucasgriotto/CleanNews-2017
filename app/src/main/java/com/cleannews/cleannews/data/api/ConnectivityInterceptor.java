package com.cleannews.cleannews.data.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.cleannews.cleannews.R;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lucas on 10/24/17.
 */

public class ConnectivityInterceptor implements Interceptor {

    public Context context;

    public ConnectivityInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        if (!(netInfo != null && netInfo.isConnected())) {
            throw new NoConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    public class NoConnectivityException extends IOException {

        @Override
        public String getMessage() {
            return context.getString(R.string.error_no_connection);
        }
    }
}
