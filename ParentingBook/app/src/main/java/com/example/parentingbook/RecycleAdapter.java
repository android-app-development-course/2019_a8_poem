package com.example.parentingbook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<Articles> list;
    private Context context;

    public RecycleAdapter(Context context,List<Articles> list){
        this.context=context;
        this.list=list;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_title;
        ImageView item_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }



    @NonNull
    @Override
    //返回一个新的ViewHolder对象
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    //绑定ViewHolder
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
        //传递数据
        Articles art=list.get(position);
        holder.item_title.setText(art.getName());
        holder.item_image.setImageResource(art.getIcon());

        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=holder.getAdapterPosition();
                Articles art=list.get(pos);

//                //跳转到指定链接
//                Intent intent = new Intent(context, WebViewActivity.class);
//                //将数据存入Intent
//                intent.putExtra("href", art.getHref());
//                context.startActivity(intent);
                Uri uri = Uri.parse(art.getHref());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
