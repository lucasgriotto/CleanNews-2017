package com.cleannews.cleannews.ui.sourcelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.common.BaseFragment;
import com.cleannews.cleannews.ui.articlelist.ArticlesActivity;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lucas on 9/1/17.
 */

public class SourcesFragment extends BaseFragment implements SourcesContract.View {

    @Inject
    SourcesPresenter presenter;
    @Inject
    SourcesAdapter sourceAdapter;

    @BindView(R.id.list_sources)
    RecyclerView listSources;
    @BindView(R.id.incl_error)
    View viewProgress;

    IncludedProgress includedProgress;

    private Unbinder unbinder;

    public SourcesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sources, container, false);
        unbinder = ButterKnife.bind(this, view);
        includedProgress = new IncludedProgress();
        ButterKnife.bind(includedProgress, viewProgress);

        setupListSources();
        setupEvents();
        return view;
    }

    private void setupListSources() {
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.divider));
        listSources.addItemDecoration(itemDecorator);
        listSources.setAdapter(sourceAdapter);
    }

    public void setupEvents() {
        includedProgress.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getSources();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sourceAdapter.setSourcerListener(listener);
        presenter.takeView(this);
        if (savedInstanceState == null)
            presenter.initialize();
        else if (presenter.hasNetworkError()) {
            showError(true, presenter.getMsgError());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        listSources.setAdapter(null);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        presenter.dropView();
        super.onDestroy();
    }

    @Override
    public void showError(boolean active, @Nullable String msg) {
        if (active) {
            includedProgress.txtError.setText(msg);
            includedProgress.layError.setVisibility(View.VISIBLE);
        } else {
            includedProgress.layError.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoading(boolean active) {
        if (active)
            includedProgress.progressBar.setVisibility(View.VISIBLE);
        else
            includedProgress.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSources(List<Source> sources) {
        sourceAdapter.replaceData(sources);
    }

    private SourcesAdapter.SourceItemListener listener = new SourcesAdapter.SourceItemListener() {
        @Override
        public void onSourceClick(Source clickedSource) {
            Intent intent = new Intent(getContext(), ArticlesActivity.class);
            intent.putExtra(ArticlesActivity.EXTRA_SOURCE, clickedSource);
            startActivity(intent);
        }
    };

    static class IncludedProgress {
        @BindView(R.id.view_progress_btn_retry)
        Button btnRetry;
        @BindView(R.id.view_progress_lay_error)
        LinearLayout layError;
        @BindView(R.id.view_progress_txt_error)
        TextView txtError;
        @BindView(R.id.view_progress_bar)
        ProgressBar progressBar;
    }

}
