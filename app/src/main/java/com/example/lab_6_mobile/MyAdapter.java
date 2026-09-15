package com.example.lab_6_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> articleList;
    LayoutInflater mInflater;

    public MyAdapter(Context context, List<Article> list) {
        mInflater = LayoutInflater.from(context);
        this.articleList = list;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.txtTitle.setText(article.getTitle());
        holder.txtContent.setText(article.getContent());
        holder.txtViews.setText("Views: " + article.getViews());
        holder.imgCover.setImageResource(article.getImgCover());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public java.util.ArrayList<Article> getArticleList() {
        return (java.util.ArrayList<Article>) articleList;
    }

//    public Article getArticleAt(int position) {
//        return articleList.get(position);
//    }
}
