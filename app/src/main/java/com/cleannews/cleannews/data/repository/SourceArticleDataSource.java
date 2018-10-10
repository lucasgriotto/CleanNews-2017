package com.cleannews.cleannews.data.repository;

import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lucas on 10/3/17.
 */

public interface SourceArticleDataSource {

    Observable<List<Article>> getArticlesBySource(Source source);

    Observable<List<Source>> getSources();
}
