package com.cleannews.cleannews.ui.sourcelist.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by lucas on 8/31/17.
 */

public class Source implements Parcelable {

    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;

    public List<String> sortBysAvailable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Source() {

    }

    protected Source(Parcel in) {
        id = in.readString();
        name = in.readString();
        sortBysAvailable = in.createStringArrayList();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeStringList(sortBysAvailable);
    }

    public static final Parcelable.Creator<Source> CREATOR = new Parcelable.Creator<Source>() {

        @Override
        public Source createFromParcel(Parcel parcel) {
            return new Source(parcel);
        }

        @Override
        public Source[] newArray(int i) {
            return new Source[0];
        }
    };
}
