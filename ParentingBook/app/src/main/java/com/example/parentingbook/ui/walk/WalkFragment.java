package com.example.parentingbook.ui.walk;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parentingbook.Articles;
import com.example.parentingbook.GlideImageLoader;
import com.example.parentingbook.R;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class WalkFragment extends Fragment {

    private WalkViewModel walkViewModel;
    //文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    //轮播图
    private ArrayList<Integer> images=new ArrayList<>();
    private ArrayList<String> titles=new ArrayList<>();
    private ArrayList<String> hrefs=new ArrayList<>();
    private Banner banner;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        walkViewModel =
                ViewModelProviders.of(this).get(WalkViewModel.class);
        View root = inflater.inflate(R.layout.fragment_walk, container, false);
        iniArticlesList();
        //轮播图
        banner = (Banner) root.findViewById(R.id.walk_banner);
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

        //tablayout
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.walk_tabLayout);
        //添加标签
        tabLayout.addTab(tabLayout.newTab().setText("兴趣培养").setIcon(R.drawable.sub_walk1));
        tabLayout.addTab(tabLayout.newTab().setText("行为引导").setIcon(R.drawable.sub_walk2));
        tabLayout.addTab(tabLayout.newTab().setText("儿童医疗").setIcon(R.drawable.sub_walk3));
//        tabLayout.addTab(tabLayout.newTab().setText("健康卫生"));

        //设置adapter，滑动时间
        final ViewPager viewPager = (ViewPager) root.findViewById(R.id.walk_viewPager);
        viewPager.setAdapter(new PageAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //绑定tab点击事件
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }
    private void iniArticlesList() {


        images.add(R.drawable.living_banner_1);
        images.add(R.drawable.living_banner_2);
        images.add(R.drawable.living_banner_3);


        titles.add("初生婴儿配置婴儿床");
        titles.add("4个月宝宝合适的睡眠时间");
        titles.add("小宝宝房间应该放些什么");


        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");
        hrefs.add("https://www.qbb6.com/article/DZNrWYfWk?src=lib&trackid=509860105&trackinfo=hhH9LrIFt4f&source=qbb&versioncode=450&env=prod");

    }
}
