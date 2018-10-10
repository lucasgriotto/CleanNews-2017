package com.cleannews.cleannews.ui.sourcelist;


import com.cleannews.cleannews.common.CallbackWrapper;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;
import com.cleannews.cleannews.ui.sourcelist.domain.usecase.GetSourcesUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lucas on 9/1/17.
 */

public class SourcesPresenter implements SourcesContract.Presenter {

    private SourcesContract.View view;
    private GetSourcesUseCase getSources;
    private boolean hasNetworkError = false;
    private String msgError;

    @Inject
    SourcesPresenter(GetSourcesUseCase getSources) {
        this.getSources = getSources;
    }

    @Override
    public void takeView(SourcesContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        getSources.dispose();
        view = null;
    }

    void initialize() {
        this.getSources();
    }

    public void getSources() {
        view.showError(false, null);
        view.showLoading(true);
        getSources.execute(new CallbackWrapper<List<Source>>() {

            @Override
            protected void onSuccess(List<Source> sources) {
                hasNetworkError = false;
                view.showSources(sources);
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
