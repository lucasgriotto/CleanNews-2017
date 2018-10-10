package com.cleannews.cleannews.ui.sourcelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cleannews.cleannews.R;
import com.cleannews.cleannews.ui.sourcelist.domain.model.Source;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lucas on 10/4/17.
 */

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.Holder> {

    private List<Source> list;
    private SourceItemListener sourcerListener;

    public interface SourceItemListener {
        void onSourceClick(Source clickedSource);
    }

    @Inject
    SourcesAdapter() {
        this.list = Collections.emptyList();
    }

    void setSourcerListener(SourceItemListener sourcerListener) {
        this.sourcerListener = sourcerListener;
    }

    void replaceData(List<Source> sources) {
        this.list = sources;
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sources, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Source item = list.get(position);
        holder.sourceName.setText(item.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sourcerListener.onSourceClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_source_name) TextView sourceName;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}