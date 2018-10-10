package com.cleannews.cleannews.ui.articledetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.common.BaseFragment;
import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lucas on 9/1/17.
 */

public class ArticleDetailFragment extends BaseFragment {

    @Inject
    Article article;

    @BindView(R.id.art_det_txt_title)
    TextView articleTitle;
    @BindView(R.id.art_det_txt_author)
    TextView articleAuthor;
    @BindView(R.id.art_det_img)
    ImageView articleImg;
    @BindView(R.id.art_det_txt_desc)
    TextView articleDesc;

    private Unbinder unbinder;

    public ArticleDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        articleTitle.setText(article.getTitle());
        articleAuthor.setText(article.getAuthor());
        if (article.getUrlToImage() != null & !article.getUrlToImage().equals("")) {
            Picasso.with(view.getContext())
                    .load(article.getUrlToImage())
                    .into(articleImg);
        }
        articleDesc.setText(article.getDescription());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
