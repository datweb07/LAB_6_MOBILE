package com.example.lab_6_mobile;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private MyAdapter myAdapter;
    public TextView txtTitle;
    public TextView txtContent;
    public TextView txtViews;
    public ImageView imgCover;

    public ArticleViewHolder(View item, MyAdapter adapter) {
        super(item);
        this.myAdapter = adapter;
        this.txtTitle = item.findViewById(R.id.txtTitle);
        this.txtContent = item.findViewById(R.id.txtContent);
        this.txtViews = item.findViewById(R.id.txtViews);
        this.imgCover = item.findViewById(R.id.imgCover);
        item.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {

            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("articleList", myAdapter.getArticleList());
            intent.putExtra("position", position);
            view.getContext().startActivity(intent);
        }
    }
}
