package com.cleannews.cleannews.common;

import org.json.JSONObject;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by lucas on 10/4/17.
 */

public abstract class CallbackWrapper<T> extends DisposableObserver<T> {

    protected abstract void onSuccess(T t);

    protected abstract void onFail(String msg);

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) t).response().errorBody();
            onFail(getErrorMessage(responseBody));
        } else {
            onFail(t.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }

    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
