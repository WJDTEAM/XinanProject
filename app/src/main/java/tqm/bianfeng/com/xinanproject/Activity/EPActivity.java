package tqm.bianfeng.com.xinanproject.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/4/20.
 * 原智慧环保网页端
 */

public class EPActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ep);
        ButterKnife.bind(this);
        initLoading(0);
        setToolbar(toolbar,"智慧环保",true,R.color.ep_green);
        initWebView();

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
        String url = "http://222.141.17.79:7001/eGovaV14/library/ep/mobile/structure/air/index.html#/air/index";
        Log.i("gqf","lawyerUrl"+url);

        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(url);


    }
    int i = 6;//apk加载进度
    SweetAlertDialog pDialog;
    CountDownTimer countDownTimer;
    public void initLoading(int index){
        if (index == 0) {
            //开始
            pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                    .setTitleText("加载中...");
            pDialog.show();
            pDialog.setCancelable(false);
            countDownTimer = new CountDownTimer(1000 * 5, 1000) {
                public void onTick(long millisUntilFinished) {
                    // you can change the progress bar color by ProgressHelper every 800 millis
                    i++;
                    switch (i % 6) {
                        case 0:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                            break;
                        case 1:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));
                            break;
                        case 2:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                            break;
                        case 3:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));
                            break;
                        case 4:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));
                            break;
                        case 5:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));
                            break;
                        case 6:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                            break;
                    }
                }

                public void onFinish() {
                    i = 6;
                    pDialog.dismiss();
                }
            }.start();

        } else {
            //结束
            pDialog.dismiss();
            countDownTimer.onFinish();
        }
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
            // html加载完成之后，添加监听图片的点击js函数
            initLoading(1);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);

        }
    }

}
