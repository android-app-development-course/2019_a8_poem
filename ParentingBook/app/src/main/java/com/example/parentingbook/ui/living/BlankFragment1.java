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

public class BlankFragment1 extends Fragment {
    //ListView文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    private ImageView adv;//头顶广告推荐位
    private BlankFragment1ViewModel mViewModel;

    public static BlankFragment1 newInstance() {
        return new BlankFragment1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.blank_fragment1_fragment, container, false);
        //初始化内容
        iniArticlesList();
        //初始化recycleview
        //RecyclerView实现
        RecyclerView rv=(RecyclerView) root.findViewById(R.id.blank_fragment_recycleview);
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
        Articles a_1 = new Articles("宝宝睡眠", R.drawable.sleep_1,
                "https://webview.babytree.com/mobile/encyclopedia/detail?type=share&id=65&moblie_share_src=pregnancy&unixtime_stamp=1575873035918&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_1);
        Articles a_2 = new Articles("最安全的婴儿睡眠姿势+美国幼儿园如何引导婴儿午睡", R.drawable.sleep_2,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=166894&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873074819&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_2);
        Articles a_3 = new Articles("孕期最正确的睡姿，快get", R.drawable.sleep_3,
                "http://babytree.citv.cn/open/content/detail?navigation_bar_hidden=true&content_id=424325&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873174485&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_3);
        Articles a_4 = new Articles("准妈妈仰卧睡让胎儿缺氧吗？", R.drawable.sleep_4,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=422629&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873206951&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_4);
        Articles a_5 = new Articles("孕妈睡不好？这些方法能帮你改善", R.drawable.sleep_5,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=424899&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873228230&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_5);
        Articles a_6 = new Articles("什么样的床垫最适合孕妈", R.drawable.sleep_6,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=426904&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873249469&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_6);
        Articles a_7 = new Articles("宝宝睡姿影响大脑发育？正确姿势大揭秘", R.drawable.sleep_7,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=321809&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873274316&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_7);
        Articles a_8 = new Articles("预防宝宝斜头畸形，注意睡眠姿势", R.drawable.sleep_8,
                "https://m.babytree.com/community/nanjing/topic_68835514.html?share_from=android_pregnancy&moblie_share_src=pregnancy&unixtime_stamp=1575873302220&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_8);
        Articles a_9 = new Articles("宝宝喜欢打呼噜，家长如何甄别是否对健康有危害？", R.drawable.sleep_9,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=448686&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873332880&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_9);
        Articles a_10 = new Articles("图解正确的抱娃姿势：横抱、竖抱、自由抱", R.drawable.sleep_10,
                "https://open.babytree.com/open/content/detail?navigation_bar_hidden=true&content_id=311154&is_out=1&moblie_share_src=pregnancy&unixtime_stamp=1575873363225&share_dest=wx_friend&share_uid=&share_bd=2019-11-29&share_pregst=6&from=singlemessage");
        articlesList.add(a_10);
    }
}
