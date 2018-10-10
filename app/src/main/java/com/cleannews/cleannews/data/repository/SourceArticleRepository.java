package com.cleannews.cleannews.data.repository;

import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by lucas on 10/3/17.
 */

@Singleton
public class SourceArticleRepository implements SourceArticleDataSource {

    private final SourceArticleDataSource sourceArticleDataSource;

    @Inject
    public SourceArticleRepository(@Named("remote") SourceArticleDataSource sourceArticleDataSource) {
        this.sourceArticleDataSource = sourceArticleDataSource;
    }

    @Override
    public Observable<List<Article>> getArticlesBySource(Source source) {
        return sourceArticleDataSource.getArticlesBySource(source);
    }

    @Override
    public Observable<List<Source>> getSources() {
        return sourceArticleDataSource.getSources();
    }
}
