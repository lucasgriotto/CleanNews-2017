package com.cleannews.cleannews.ui.articlelist.domain.usecase;

import com.cleannews.cleannews.common.UseCase;
import com.cleannews.cleannews.data.repository.SourceArticleRepository;
import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by lucas on 9/5/17.
 */

public class GetArticlesBySource extends UseCase<List<Article>> {

    @Inject
    Source source;
    private SourceArticleRepository sourceArticleRepository;

    @Inject
    public GetArticlesBySource(@Named("executor_thread") Scheduler executorThread,
                               @Named("ui_thread") Scheduler uiThread,
                               SourceArticleRepository sourceArticleRepository) {
        super(executorThread, uiThread);
        this.sourceArticleRepository = sourceArticleRepository;
    }

    @Override
    protected Observable<List<Article>> createObservableUseCase() {
        return sourceArticleRepository.getArticlesBySource(source);
    }

    @Override
    public void execute(DisposableObserver<List<Article>> disposableObserver) {
        super.execute(disposableObserver);
    }
}
