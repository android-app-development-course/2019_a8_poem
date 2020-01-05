package com.example.parentingbook;


//文章类，可以在对应java文件中添加或删除文章
public class Articles {
    private String name;
    private int icon;
    private String href;

    //初始化
    public Articles(String n, int i, String f){
        this.name = n;
        this.icon = i;
        this.href = f;
    }

    //设置
    public void setName(String name) {
        this.name = name;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    //获取
    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    public int getIcon() {
        return icon;
    }
}
