package com.cleannews.cleannews.ui.articlelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.common.Utils;
import com.cleannews.cleannews.ui.articlelist.domain.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lucas on 9/1/17.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.Holder> {

    private List<Article> list;
    private ArticleItemListener articleListener;

    public interface ArticleItemListener {
        void onArticleClick(Article clickedArticle);
    }

    @Inject
    ArticlesAdapter() {

    }

    void setArticleListener(ArticleItemListener articleListener) {
        this.articleListener = articleListener;
    }

    void submitData(List<Article> articles) {
        this.list = articles;
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_articles, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Article item = list.get(position);
        holder.articleTitle.setText(item.getTitle());
        if (item.getPublishedAt() != null) {
            holder.articleDate.setText(Utils.dateToStringDateFormat(item.getPublishedAt()));
        }
        if (item.getUrlToImage() != null & !item.getUrlToImage().equals("")) {
            holder.articleImg.setVisibility(View.VISIBLE);
            Picasso.with(holder.itemView.getContext())
                    .load(item.getUrlToImage())
                    .fit()
                    .centerInside()
                    .into(holder.articleImg);
        } else {
            holder.articleImg.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articleListener.onArticleClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_art_title)
        TextView articleTitle;
        @BindView(R.id.row_art_img)
        ImageView articleImg;
        @BindView(R.id.row_art_date)
        TextView articleDate;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
