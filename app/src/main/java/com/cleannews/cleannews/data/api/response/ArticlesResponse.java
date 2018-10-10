package com.cleannews.cleannews.data.api.response;

import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lucas on 9/1/17.
 */

public class ArticlesResponse {

    @SerializedName("articles")
    @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
