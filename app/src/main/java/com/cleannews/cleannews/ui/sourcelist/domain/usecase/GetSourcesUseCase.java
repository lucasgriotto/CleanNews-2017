package com.cleannews.cleannews.ui.sourcelist.domain.usecase;

import com.cleannews.cleannews.common.UseCase;
import com.cleannews.cleannews.data.repository.SourceArticleRepository;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by lucas on 9/5/17.
 */

public class GetSourcesUseCase extends UseCase<List<Source>> {

    private SourceArticleRepository mSourceArticleRepository;

    @Inject
    GetSourcesUseCase(@Named("executor_thread") Scheduler executorThread,
                             @Named("ui_thread") Scheduler uiThread,
                             SourceArticleRepository sourceArticleRepository) {
        super(executorThread, uiThread);
        this.mSourceArticleRepository = sourceArticleRepository;
    }

    @Override
    protected Observable<List<Source>> createObservableUseCase() {
        return mSourceArticleRepository.getSources();
    }
}
