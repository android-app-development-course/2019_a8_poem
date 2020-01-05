package com.example.parentingbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    //APP内打开链接

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //获得控件
        WebView webView = (WebView) findViewById(R.id.wv);
        //获得Intent对象
        Intent intent=getIntent();
        //取出key对应的value
        String href=intent.getStringExtra("href");
        //访问网页
        webView.loadUrl(href);
        webView.getSettings().setJavaScriptEnabled(true);  //支持JS

        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url=request.getUrl().toString();
                //使用WebView加载显示request,webview只能识别http, https这样的协议
                if(url.startsWith("http:")||url.startsWith("https:")){
                    view.loadUrl(url);
                }
                else {//否则第三方应用打开
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }

                //返回true
                return true;
            }
        });
    }

}
