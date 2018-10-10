package com.cleannews.cleannews.ui.articlelist.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by lucas on 8/31/17.
 */

public class Article implements Parcelable {

    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    Date publishedAt;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Article() {

    }

    public Article(Parcel in) {
        author = in.readString();
        title = in.readString();
        description = in.readString();
        urlToImage = in.readString();
        publishedAt = (Date) in.readSerializable();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(author);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(urlToImage);
        parcel.writeSerializable(publishedAt);
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {

        @Override
        public Article createFromParcel(Parcel parcel) {
            return new Article(parcel);
        }

        @Override
        public Article[] newArray(int i) {
            return new Article[0];
        }
    };

}
