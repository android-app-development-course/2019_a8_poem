package com.example.parentingbook.ui.living;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parentingbook.Articles;
import com.example.parentingbook.R;
import com.example.parentingbook.RecycleAdapter;
import com.example.parentingbook.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment2 extends Fragment {
    //ListView文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    private ImageView adv;//头顶广告推荐位
    private BlankFragment1ViewModel mViewModel;

    public static BlankFragment2 newInstance() {
        return new BlankFragment2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.blank_fragment2_fragment, container, false);
        //初始化内容
        iniArticlesList();
        //初始化recycleview
        //RecyclerView实现
        RecyclerView rv=(RecyclerView) root.findViewById(R.id.blank_fragment_recycleview2);
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
        mViewModel = ViewModelProviders.of(this).get(BlankFragment1ViewModel.class);
        // TODO: Use the ViewModel
    }

    private void iniArticlesList(){
        //cloth_ListView文章
        Articles a_1 = new Articles("5个小细节，让你房间更舒服", R.drawable.a1,
                "http://suo.im/6xL31t\n");
        articlesList.add(a_1);
        Articles a_2 = new Articles("夏天新生宝宝可以吹空调、电风扇吗？", R.drawable.a2,
                "http://suo.im/5AlWTT\n");
        articlesList.add(a_2);
        Articles a_3 = new Articles("婴儿摇篮有必要买吗", R.drawable.a3,
                "http://suo.im/63GDG9\n");
        articlesList.add(a_3);
        Articles a_4 = new Articles("孕妈妈用电脑多会影响胎儿吗", R.drawable.a4,
                "http://suo.im/63GBHf\n");
        articlesList.add(a_4);
        Articles a_5 = new Articles("如何布置宝宝的房间", R.drawable.room_1,
                "http://suo.im/5sPTog\n");
        articlesList.add(a_5);
        Articles a_6 = new Articles("警惕房间的色彩伤害宝宝，这样搭配最合理！", R.drawable.room_2,
                "http://suo.im/63GnjX\n");
        articlesList.add(a_6);
        Articles a_7 = new Articles("新生宝宝睡不好？可能是卧室得原因", R.drawable.room_3,
                "http://suo.im/6iIO2F\n");
        articlesList.add(a_7);
    }
}
