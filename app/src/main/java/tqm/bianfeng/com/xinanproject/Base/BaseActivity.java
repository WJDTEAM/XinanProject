package tqm.bianfeng.com.xinanproject.Base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import io.realm.Realm;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.Util.DisplayUtil;
import tqm.bianfeng.com.xinanproject.Util.SystemBarTintManager;



/**
 * Created by johe on 2017/3/14.
 */

public class BaseActivity extends SwipeBackActivity implements InitViewInterface{

    protected Realm realm;
    protected CompositeSubscription compositeSubscription;
    protected Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        realm= Realm.getDefaultInstance();
        compositeSubscription=new CompositeSubscription();
    }

    public void setToolbar(Toolbar toolbar, String msg,boolean isHasBack,int color){
        mToolbar=toolbar;
        if(!msg.equals("")) {
            toolbar.setTitle(msg);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        }
        if(isHasBack) {
            //setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.barcode__back_arrow);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
        if(color!=0) {
            setSystemBarColor(color,isHasBack);
        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
        compositeSubscription.unsubscribe();
    }


    public void setSystemBarColor(int id,boolean isHasBack){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //此处可以重新指定状态栏颜色
            tintManager.setStatusBarTintResource(id);
        }
        else{
            if(mToolbar!=null) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mToolbar.getLayoutParams();
                lp.height = DisplayUtil.dip2px(this, getResources().getDimension(R.dimen.bigxmdp));
                mToolbar.setLayoutParams(lp);
                if(isHasBack){
                    mToolbar.setNavigationIcon(R.drawable.ic_write_back_small);
                }
            }
        }
    }



}