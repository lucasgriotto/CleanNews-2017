package com.cleannews.cleannews.ui.articlelist;


import com.cleannews.cleannews.common.CallbackWrapper;
import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.cleannews.cleannews.ui.articlelist.domain.usecase.GetArticlesBySource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lucas on 9/1/17.
 */

public class ArticlesPresenter implements ArticlesContract.Presenter {

    private ArticlesContract.View view;
    private GetArticlesBySource getArticleList;

    private boolean hasNetworkError = false;
    private String msgError;

    @Inject
    ArticlesPresenter(GetArticlesBySource getArticleList) {
        this.getArticleList = getArticleList;
    }

    @Override
    public void takeView(ArticlesContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        getArticleList.dispose();
        view = null;
    }

    void initialize() {
        this.getArticleList();
    }

    public void getArticleList() {
        view.showError(false, null);
        view.showLoading(true);
        getArticleList.execute(new CallbackWrapper<List<Article>>() {

            @Override
            protected void onSuccess(List<Article> articles) {
                hasNetworkError = false;
                view.showArticles(articles);
                view.showLoading(false);
            }

            @Override
            protected void onFail(String msg) {
                hasNetworkError = true;
                msgError = msg;
                view.showLoading(false);
                view.showError(true,msg);
            }

        });
    }

    boolean hasNetworkError() {
        return hasNetworkError;
    }

    String getMsgError() {
        return msgError;
    }
}
