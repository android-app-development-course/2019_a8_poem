package com.example.parentingbook.ui.living;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

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

public class LivingFragment extends Fragment {

    private LivingViewModel livingViewModel;
    //文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    //轮播图
    private ArrayList<Integer> images=new ArrayList<>();
    private ArrayList<String> titles=new ArrayList<>();
    private ArrayList<String> hrefs=new ArrayList<>();
    private Banner banner;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        livingViewModel =
                ViewModelProviders.of(this).get(LivingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_living, container, false);
        //类实现、ListView与适配qi
        iniArticlesList();
        //轮播图
        banner = (Banner) root.findViewById(R.id.banner);
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
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);
        //添加标签
        tabLayout.addTab(tabLayout.newTab().setText("睡眠姿势").setIcon(R.drawable.sub_living4));
        tabLayout.addTab(tabLayout.newTab().setText("家具布局").setIcon(R.drawable.sub_living1));
        tabLayout.addTab(tabLayout.newTab().setText("睡眠时间").setIcon(R.drawable.sub_living3));
//        tabLayout.addTab(tabLayout.newTab().setText("房间装饰").setIcon(R.drawable.sub_living2));

        //设置adapter，滑动时间
        final ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewPager);
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