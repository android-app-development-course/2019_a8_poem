package com.example.parentingbook.ui.food;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parentingbook.Articles;
import com.example.parentingbook.R;
import com.example.parentingbook.RecycleAdapter;
import com.example.parentingbook.SpacesItemDecoration;
import com.example.parentingbook.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class Food_Specialrecipes_Activity extends AppCompatActivity {
    //ListView文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    private ImageView adv;//头顶广告推荐位

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title,如果Activity继承了AppCompatActivity，这个就失效了
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.food_specialrecipes);

        //类实现、ListView与适配器
        iniArticlesList();
        //RecyclerView实现
        RecyclerView rv=(RecyclerView)findViewById(R.id.food_specialrecipes_articles);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RecycleAdapter myadapter=new RecycleAdapter(this,articlesList);
        //设置间距
        rv.addItemDecoration(new SpacesItemDecoration(10));
        rv.setAdapter(myadapter);

        adv=(ImageView)findViewById(R.id.food_specialrecipes_adv);
        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //跳转到指定链接
//                Intent intent = new Intent(Food_Specialrecipes_Activity.this, WebViewActivity.class);
//                //将数据存入Intent
//                intent.putExtra("href", "https://www.baidu.com/");
//                startActivity(intent);
                Uri uri = Uri.parse("https://www.qbb6.com/article/rJgIPOckJ?src=pnews&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=440&env=prod&from=singlemessage");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void iniArticlesList(){
        //cloth_ListView文章
        Articles a_1 = new Articles("0到3个月的宝宝吃什么？", R.drawable.f1,
                "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_1);
        Articles a_2 = new Articles("哺乳期，吃对食物让宝宝获得充足DHA", R.drawable.f2, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_2);
        Articles a_3 = new Articles("母乳对宝宝更好吗？", R.drawable.f3, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_3);
        Articles a_4 = new Articles("宝宝吐奶怎么办？不用愁！", R.drawable.f4, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_4);
        Articles a_5 = new Articles("宝宝不吃饭急死人，这几个方法最实用", R.drawable.f5, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_5);
        Articles a_6 = new Articles("中华人民共和国婴幼儿食品安全", R.drawable.f6, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_6);
        Articles a_7 = new Articles("你不知道的婴幼儿食品安全知识", R.drawable.f7, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_7);
        Articles a_8 = new Articles("4个月宝宝穿衣指南", R.drawable.f8, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_8);
        Articles a_9 = new Articles("7到9个月宝宝穿衣指南", R.drawable.f9, "https://www.qbb6.com/recipe/plan/NelcCMF?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_9);
    }
}

