package com.cleannews.cleannews.data.api.response;

import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lucas on 9/1/17.
 */

public class SourcesResponse {

    @SerializedName("sources")
    @Expose
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
