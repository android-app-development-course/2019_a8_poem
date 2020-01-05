package com.example.parentingbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticlesAdapter extends ArrayAdapter<Articles> {
    private int resourceId;//item布局的资源ID

    //将上下文、ListView子项布局的id、数据 传递进来
    public ArticlesAdapter(Context context, int ResourceId, List<Articles> obj){
        //super()表示调用父类的构造方法，只是调用方法，不构造对象。
        super(context,ResourceId,obj);
        resourceId=ResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Articles art=getItem(position);//当前Articl对象
        RecyclerView.ViewHolder hodler;//RecyclerView实现，暂时不搞
        View view;

        view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        //传递图片
        ImageView mImage=(ImageView)view.findViewById(R.id.item_image);
        mImage.setBackgroundResource(art.getIcon());
        //传递姓名
        TextView mTextView=(TextView)view.findViewById(R.id.item_title);
        mTextView.setText(art.getName());

        return view;
//        return super.getView(position, convertView, parent);
    }
}
