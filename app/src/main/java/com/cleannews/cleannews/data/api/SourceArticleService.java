package com.cleannews.cleannews.data.api;

import com.cleannews.cleannews.data.api.response.ArticlesResponse;
import com.cleannews.cleannews.data.api.response.SourcesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lucas on 10/3/17.
 */

public interface SourceArticleService {

    @GET("articles")
    Observable<ArticlesResponse> getArticlesBySource(@Query("sortBy") String sortBy, @Query("source") String sourceId);

    @GET("sources")
    Observable<SourcesResponse> getSources();
}