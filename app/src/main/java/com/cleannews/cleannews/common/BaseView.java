package com.cleannews.cleannews.common;

import javax.annotation.Nullable;

/**
 * Created by lucas on 10/4/17.
 */

public interface BaseView {

    void showError(boolean active, @Nullable String msg);

    void showLoading(boolean active);
}
