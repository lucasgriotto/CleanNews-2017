package com.cleannews.cleannews.ui.articledetail;

import android.os.Bundle;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.common.BaseActivity;

/**
 * Created by lucas on 9/1/17.
 */

public class ArticleDetailActivity extends BaseActivity {

    public static final String EXTRA_ARTICLE = "ARTICLE";
    public static final String EXTRA_TITLE = "TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_TITLE));
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ArticleDetailFragment());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}