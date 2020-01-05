package com.example.parentingbook.ui.walk;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.parentingbook.Articles;
import com.example.parentingbook.R;
import com.example.parentingbook.RecycleAdapter;
import com.example.parentingbook.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class Walk_Fragment1 extends Fragment {
    //ListView文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    private ImageView adv;//头顶广告推荐位
    private WalkFragment1ViewModel mViewModel;

    public static Walk_Fragment1 newInstance() {
        return new Walk_Fragment1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.walk__fragment1_fragment, container, false);
        //初始化内容
        iniArticlesList();
        //初始化recycleview
        //RecyclerView实现
        RecyclerView rv=(RecyclerView) root.findViewById(R.id.walk_fragment_recycleview);
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
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WalkFragment1ViewModel.class);
        // TODO: Use the ViewModel
    }
    private void iniArticlesList(){
        //cloth_ListView文章
        Articles a_1 = new Articles("儿童医疗", R.drawable.a1,
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
