package com.cleannews.cleannews.ui.articlelist;

import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.cleannews.cleannews.common.BasePresenter;
import com.cleannews.cleannews.common.BaseView;

import java.util.List;

/**
 * Created by lucas on 10/4/17.
 */

public interface ArticlesContract {

    interface View extends BaseView {

        void showArticles(List<Article> articles);
    }

    interface Presenter extends BasePresenter<View> {

        void takeView(ArticlesContract.View view);

        void dropView();
    }
}
