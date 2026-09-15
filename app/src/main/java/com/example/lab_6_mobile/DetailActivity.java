package com.example.lab_6_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgCover = findViewById(R.id.imgDetailCover);
        TextView txtTitle = findViewById(R.id.txtDetailTitle);
        TextView txtViews = findViewById(R.id.txtDetailViews);
        TextView txtContent = findViewById(R.id.txtDetailContent);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("articleList") && intent.hasExtra("position")) {
            ArrayList<Article> articleList = (ArrayList<Article>) intent.getSerializableExtra("articleList");
            int position = intent.getIntExtra("position", -1);
            
            if (articleList != null && position != -1) {
                Article article = articleList.get(position);
                

                article.setViews(article.getViews() + 1);
                
                imgCover.setImageResource(article.getImgCover());
                txtTitle.setText(article.getTitle());
                txtViews.setText("Views: " + article.getViews());
                txtContent.setText(article.getContent());
                

                btnBack.setOnClickListener(v -> {
                    Intent backIntent = new Intent(DetailActivity.this, MainActivity.class);

                    backIntent.putExtra("articleList", articleList);
                    startActivity(backIntent);
                    finish();
                });
            }
        }
    }
}
