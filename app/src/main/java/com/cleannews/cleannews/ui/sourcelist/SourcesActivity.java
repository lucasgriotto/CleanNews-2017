package com.cleannews.cleannews.ui.sourcelist;

import android.os.Bundle;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.common.BaseActivity;

/**
 * Created by lucas on 10/4/17.
 */

public class SourcesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new SourcesFragment());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
