package com.cleannews.cleannews.common;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by lucas on 9/1/17.
 */

public abstract class UseCase<T> {

    private final CompositeDisposable compositeDisposable;
    private final Scheduler executorThread;
    private final Scheduler uiThread;

    public UseCase(Scheduler executorThread, Scheduler uiThread) {
        this.executorThread = executorThread;
        this.uiThread = uiThread;
        compositeDisposable = new CompositeDisposable();
    }

    public void execute(DisposableObserver<T> disposableObserver) {
        if (disposableObserver == null)
            throw new IllegalArgumentException("disposableObserver must not be null");

        final Observable<T> observable =
                this.createObservableUseCase().subscribeOn(executorThread).observeOn(uiThread);

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected abstract Observable<T> createObservableUseCase();
}
