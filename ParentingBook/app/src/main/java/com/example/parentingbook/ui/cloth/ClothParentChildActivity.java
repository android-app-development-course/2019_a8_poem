package com.example.parentingbook.ui.cloth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.parentingbook.Articles;
import com.example.parentingbook.R;
import com.example.parentingbook.RecycleAdapter;
import com.example.parentingbook.WebViewActivity;
import com.example.parentingbook.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ClothParentChildActivity extends AppCompatActivity {
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
        setContentView(R.layout.cloth_parentchild);

        //类实现、ListView与适配器
        iniArticlesList();
        //RecyclerView实现
        RecyclerView rv=(RecyclerView)findViewById(R.id.cloth_parentchild_articles);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RecycleAdapter myadapter=new RecycleAdapter(this,articlesList);
        //设置间距
        rv.addItemDecoration(new SpacesItemDecoration(10));
        rv.setAdapter(myadapter);

        adv=(ImageView)findViewById(R.id.cloth_parentchild_adv);
        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //跳转到指定链接
//                Intent intent = new Intent(ClothParentChildActivity.this, WebViewActivity.class);
//                //将数据存入Intent
//                intent.putExtra("href", "https://www.qbb6.com/article/rJgIPOckJ?src=pnews&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=440&env=prod&from=singlemessage");
//                startActivity(intent);
                Uri uri = Uri.parse("https://www.qbb6.com/article/rJgIPOckJ?src=pnews&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=440&env=prod&from=singlemessage");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
    }

    private void iniArticlesList(){
        //cloth_ListView文章
        Articles a_1 = new Articles("0到3个月宝宝穿衣指南", R.drawable.a1,
                "https://www.qbb6.com/article/rJgIPOckJ?src=pnews&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=440&env=prod&from=singlemessage");
        articlesList.add(a_1);
        Articles a_2 = new Articles("宝宝穿衣温度对照表？怎么辨别宝宝穿对衣服", R.drawable.a2,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_2);
        Articles a_3 = new Articles("新手妈妈看过来，宝宝最全穿衣指南，0-12个月的宝宝这样穿又好看又保暖！", R.drawable.a3,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_3);
        Articles a_4 = new Articles("色彩过于鲜艳的衣服别给宝宝买！", R.drawable.a4,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_4);
        Articles a_5 = new Articles("如何选购宝宝衣物？一看二闻三洗", R.drawable.a5,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_5);
        Articles a_6 = new Articles("中华人民共和国婴幼儿服装标准", R.drawable.a6,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_6);
        Articles a_7 = new Articles("你不知道的婴幼儿服装用品设计", R.drawable.a7,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_7);
        Articles a_8 = new Articles("4个月宝宝穿衣指南", R.drawable.a8,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_8);
        Articles a_9 = new Articles("7到9个月宝宝穿衣指南", R.drawable.a9,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_9);
        Articles a_10 = new Articles("10~12个月宝宝穿衣指南", R.drawable.a10,
                "https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        articlesList.add(a_10);
    }
}
