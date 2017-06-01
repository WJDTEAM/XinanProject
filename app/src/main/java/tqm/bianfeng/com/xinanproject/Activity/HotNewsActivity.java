package tqm.bianfeng.com.xinanproject.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.CustomView.LoadingIndicator;
import tqm.bianfeng.com.xinanproject.R;

import static tqm.bianfeng.com.xinanproject.R.id.webview;

/**
 * Created by johe on 2017/4/21.
 * 网页插件
 */

public class HotNewsActivity extends BaseActivity {

    @BindView(webview)
    WebView webView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //新安新闻
    public static final String HOT_NEWS_URL = "https://mp.weixin.qq.com/mp/homepage?__biz=MzA4NzE5MzAyMw==&hid=2&sn=44f6c5ea8762ea10330feb1e79d9a98b#wechat_redirect";
    //中国搜索
    public static final String CHINA_SEARCH_URL = "http://m.chinaso.com/";
    //营养推荐
    public static final String NUTRITION_URL = "http://mp.weixin.qq.com/mp/homepage?__biz=MzA5NjQwMTQxOA==&hid=3&sn=4c6e76601660c9fadd0c36f0f6a01297#wechat_redirect";
    //运动与安全
    public static final String HEALTH_URL = "http://mp.weixin.qq.com/mp/homepage?__biz=MzA5NjQwMTQxOA==&hid=7&sn=4ac2f39d2f69fa2ad4ad233449ea8a99#wechat_redirect";
    //旅游推荐
    public static final String RECOMMENDATION_URL= "http://wap.zhongzhiyunyou.com:8084/ictt-wechat/scenic/XinAn.action";

    //火车查询
    public static final String CAR_URL= "https://m.huoche.net/";
    String url ;//= "https://mp.weixin.qq.com/mp/homepage?__biz=MzA4NzE5MzAyMw==&hid=2&sn=44f6c5ea8762ea10330feb1e79d9a98b#wechat_redirect";

    @BindView(R.id.indicator)
    LoadingIndicator indicator;

    String nowUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_news);
        ButterKnife.bind(this);

        String title="";
        url = getIntent().getStringExtra("url");
        int color=R.color.colorPrimary;
        if(url.equals(HOT_NEWS_URL)){
            title="热点新闻";
            nowUrl=HOT_NEWS_URL;
            color=R.color.HOT_NEWS;
        }else if(url.equals(CHINA_SEARCH_URL)){
            title="中国搜索";
            nowUrl=CHINA_SEARCH_URL;
            color=R.color.CHINA_SEARCH;
        }else if(url.equals(NUTRITION_URL)){
            title="营养推荐";
            nowUrl=NUTRITION_URL;
            color=R.color.NUTRITION;
        }else if(url.equals(HEALTH_URL)){
            title="运动与安全";
            nowUrl=HEALTH_URL;
        }else if(url.equals(RECOMMENDATION_URL)){
            title="旅游推荐";
            nowUrl=RECOMMENDATION_URL;
            color=R.color.RECOMMENDATION;
        }else if(url.equals(CAR_URL)){
            title="火车查询";
            nowUrl=CAR_URL;
            color=R.color.RECOMMENDATION;
        }

        setToolbar(toolbar, title, true,color);
        toolbar.setBackgroundResource(color);

        indicator.showLoading();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webBack();
            }
        });
        initWebView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {

            webBack();
        }

        return false;

    }

    public void webBack(){
        nowUrl=webView.getUrl();
        Log.i("gqf","url"+url);
        Log.i("gqf","nowUrl"+nowUrl);

        if(nowUrl.equals(url)||!webView.canGoBack()){
            onBackPressed();
        }else{
            webView.goBack();
        }
    }
    public void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setAppCacheEnabled(true);//设置启动缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//缓存模式
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//4.4以下版本自适应页面大小 不能左右滑动
        //        1.NARROW_COLUMNS：可能的话使所有列的宽度不超过屏幕宽度
        //        2.NORMAL：正常显示不做任何渲染
        //        3.SINGLE_COLUMN：把所有内容放大webview等宽的一列中
        settings.setUseWideViewPort(true);//设置webview推荐使用的窗口
        settings.setLoadWithOverviewMode(true);//设置webview加载的页面的模式
        settings.setTextZoom(100);//字体大小
        settings.setJavaScriptEnabled(true);//支持js
        settings.setSupportZoom(true);//仅支持双击缩放
        webView.setInitialScale(57);//最小缩放等级
        webView.getSettings().setBlockNetworkImage(false);//阻止图片网络数据
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);//图片加载放在最后
        webView.setVerticalScrollBarEnabled(false);//滚动条不显示
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);// 出现放大缩小提示
        webView.getSettings().setDisplayZoomControls(false);//隐藏缩放按钮


        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
            // html加载完成之后，添加监听图片的点击js函数

            indicator.hideLoading();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }


    }
}
