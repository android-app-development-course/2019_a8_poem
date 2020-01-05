package com.example.parentingbook.ui.cloth;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.engine.Resource;
import com.example.parentingbook.Articles;
import com.example.parentingbook.GlideImageLoader;
import com.example.parentingbook.R;
import com.example.parentingbook.RecycleAdapter;
import com.example.parentingbook.WebViewActivity;
import com.example.parentingbook.SpacesItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class ClothFragment extends Fragment {

    private ClothViewModel clothViewModel;

    //文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();

    //子话题
    private ImageView health;
    private ImageView parentchild;
    private ImageView season;
    private ImageView comfortable;
    //轮播图
    private ArrayList<Integer> images=new ArrayList<>();
    private ArrayList<String> titles=new ArrayList<>();
    private ArrayList<String> hrefs=new ArrayList<>();
    private Banner banner;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clothViewModel =
                ViewModelProviders.of(this).get(ClothViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cloth, container, false);

        //类实现、ListView与适配器
        iniArticlesList();

        //RecyclerView实现
        RecyclerView rv=(RecyclerView) root.findViewById(R.id.cloth_main_art);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleAdapter myadapter=new RecycleAdapter(getContext(),articlesList);
        //设置间距
        rv.addItemDecoration(new SpacesItemDecoration(10));
        rv.setAdapter(myadapter);

        //下拉隐藏导航栏
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>3){
                    getActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);
                }else if(dy<-3){
                    getActivity().findViewById(R.id.nav_view).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        //跳转到子话题
        health=(ImageView)root.findViewById(R.id.cloth_item1_image) ;
        parentchild=(ImageView)root.findViewById(R.id.cloth_item2_image) ;
        season=(ImageView)root.findViewById(R.id.cloth_item3_image) ;
        comfortable=(ImageView)root.findViewById(R.id.cloth_item4_image) ;

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到cloth_health界面
                Intent intent=new Intent(getContext(),ClothHealthActivity.class);
                startActivity(intent);
            }
        });
        parentchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到cloth_health界面
                Intent intent=new Intent(getContext(),ClothParentChildActivity.class);
                startActivity(intent);
            }
        });
        season.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到cloth_health界面
                Intent intent=new Intent(getContext(),ClothSeasonActivity.class);
                startActivity(intent);
            }
        });
        comfortable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到cloth_health界面
                Intent intent=new Intent(getContext(),ClothComfortableActivity.class);
                startActivity(intent);
            }
        });


        //轮播图
        banner = (Banner) root.findViewById(R.id.cloth_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                String href=hrefs.get(position);
                Uri content_url = Uri.parse(href);
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        return root;

    }

    //文章
    private void iniArticlesList() {
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

        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a4);
        images.add(R.drawable.a5);

        titles.add("0到3个月宝宝穿衣指南");
        titles.add("4个月宝宝穿衣指南");
        titles.add("7到9个月宝宝穿衣指南");
        titles.add("10~12个月宝宝穿衣指南");
        titles.add("中华人民共和国婴幼儿服装标准");

        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
    }
}