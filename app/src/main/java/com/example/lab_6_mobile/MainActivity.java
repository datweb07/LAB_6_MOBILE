package com.example.lab_6_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    // Button btnLoad;
    List<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        android.content.Intent intent = getIntent();
        if (intent != null && intent.hasExtra("articleList")) {
            articleList = (ArrayList<Article>) intent.getSerializableExtra("articleList");
        } else {

            articleList.add(new Article(
                    "Trường đại học Kinh tế TP.HCM sẽ chuyển thành Đại học UEH",
                    "Trong đề án tái cấu trúc của mình, Trường Đại học Kinh tế TP.HCM (UEH) sẽ trở thành một đại học đa ngành với tên gọi mới là Đại học UEH, gồm 5 trường thành viên...",
                    R.drawable.ueh1, 0));
                    
            articleList.add(new Article(
                    "Trường Đại học Kinh tế TPHCM (UEH): 45 năm hành trình hướng đến Đại học UEH đa ngành và bền vững",
                    "Hành trình 45 năm xây dựng và phát triển (27-10-1976 - 27-10-2021), Trường Đại học Kinh Tế TPHCM (UEH) đã khẳng định vị trí quan trọng trên bản đồ giáo dục đại học của Việt Nam, từng bước ghi dấu danh tiếng học thuật trên thị trường thế giới, đóng góp có hiệu quả vào sự nghiệp xây dựng và phát triển kinh tế - xã hội của đất nước. Tiếp tục duy trì và phát huy những thành quả 45 năm qua, UEH chính thức hướng đến hình thành đại học đa ngành và bền vững trên chặng đường phát triển mới.",
                    R.drawable.ueh2, 0));
                    
            articleList.add(new Article(
                    "UEH chính thức khởi động mùa tuyển sinh đại học chính quy 2026",
                    "Đại học Kinh tế TP. Hồ Chí Minh (UEH) chính thức công bố thông tin tuyển sinh đại học chính quy năm 2026 với nhiều điểm đổi mới nổi bật trong phương thức xét tuyển, chương trình đào tạo và chiến lược quốc tế hóa, tiếp tục khẳng định vị thế là một trong những đại học hàng đầu Việt Nam và khu vực.",
                    R.drawable.ueh3, 0));
        }

        recyclerView = findViewById(R.id.recyclerView);
        // btnLoad = findViewById(R.id.btnLoad);
        

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // btnLoad.setOnClickListener(view -> {
        //     MyAdapter myAdapter = new MyAdapter(view.getContext(), articleList);
        //     recyclerView.setLayoutManager(
        //             new LinearLayoutManager(this)
        //     );
        //     recyclerView.setAdapter(myAdapter);
        // });
        
        MyAdapter myAdapter = new MyAdapter(this, articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
