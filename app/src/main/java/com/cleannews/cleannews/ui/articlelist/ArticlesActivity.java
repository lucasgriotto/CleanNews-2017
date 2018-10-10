package com.cleannews.cleannews.ui.articlelist;

import android.os.Bundle;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.common.BaseActivity;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import javax.inject.Inject;

public class ArticlesActivity extends BaseActivity {

    @Inject
    Source source;

    public static final String EXTRA_SOURCE = "SOURCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(source.getName());
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ArticlesFragment());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
