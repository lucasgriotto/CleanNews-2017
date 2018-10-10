package com.cleannews.cleannews.data.repository.remote;

import com.cleannews.cleannews.data.api.SourceArticleService;
import com.cleannews.cleannews.data.api.response.ArticlesResponse;
import com.cleannews.cleannews.data.api.response.SourcesResponse;
import com.cleannews.cleannews.data.repository.SourceArticleDataSource;
import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by lucas on 10/3/17.
 */

@Singleton
public class SourceArticleRemoteDataSource implements SourceArticleDataSource {

    private SourceArticleService sourceArticleService;

    @Inject
    public SourceArticleRemoteDataSource(SourceArticleService sourceArticleService) {
        this.sourceArticleService = sourceArticleService;
    }

    @Override
    public Observable<List<Article>> getArticlesBySource(Source source) {
        return sourceArticleService.getArticlesBySource(source.getSortBysAvailable().get(0), source.getId())
                .map(new Function<ArticlesResponse, List<Article>>() {
                    @Override
                    public List<Article> apply(@NonNull ArticlesResponse articlesResponse) {
                        return articlesResponse.getArticles();
                    }
                });
    }

    @Override
    public Observable<List<Source>> getSources() {
        return sourceArticleService.getSources()
                .map(new Function<SourcesResponse, List<Source>>() {
                    @Override
                    public List<Source> apply(@NonNull SourcesResponse sourcesResponse) {
                        return sourcesResponse.getSources();
                    }
                });
    }
}
