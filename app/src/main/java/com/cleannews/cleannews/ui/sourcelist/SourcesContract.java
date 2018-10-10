package com.cleannews.cleannews.ui.sourcelist;

import com.cleannews.cleannews.common.BasePresenter;
import com.cleannews.cleannews.common.BaseView;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

/**
 * Created by lucas on 10/4/17.
 */

public interface SourcesContract {

    interface View extends BaseView {

        void showSources(List<Source> sources);
    }

    interface Presenter extends BasePresenter<View> {

        void takeView(SourcesContract.View view);

        void dropView();
    }
}
