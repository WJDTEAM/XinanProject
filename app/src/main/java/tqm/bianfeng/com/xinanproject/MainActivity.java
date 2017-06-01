package tqm.bianfeng.com.xinanproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.realm.Realm;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.Base.BaseApplication;
import tqm.bianfeng.com.xinanproject.Home.DrawerFragment;
import tqm.bianfeng.com.xinanproject.Home.HomeFragment;
import tqm.bianfeng.com.xinanproject.Util.DisplayUtil;
import tqm.bianfeng.com.xinanproject.Util.SystemBarTintManager;
import tqm.bianfeng.com.xinanproject.contact.ContactFragment;
import tqm.bianfeng.com.xinanproject.user.UserFragment;
import tqm.bianfeng.com.xinanproject.zxing.activity.CaptureActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity implements HomeFragment.mListener, ContactFragment.mListener {

    private static final String HOME_TAG = "home_flag";
    private static final String CONTACT_TAG = "contact_flag";
    private static final String USER_TAG = "user_flag";
    private static final int CONTENT_HOME = 1;
    private static final int CONTENT_CONTACT = 2;
    private static final int CONTENT_USER = 3;

    @BindView(R.id.main_frag)
    FrameLayout mainFrag;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    CompositeSubscription compositeSubscription;

    HomeFragment homeFragment;
    ContactFragment contactFragment;
    UserFragment userFragment;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Context mContext;
    protected Realm realm;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    DrawerFragment drawerFragment;
    @BindView(R.id.open_drawer_img)
    ImageView openDrawerImg;
    @BindView(R.id.bottomBar)
    BottomNavigationBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        toolbar.setTitle("");
        realm = Realm.getDefaultInstance();
        compositeSubscription = new CompositeSubscription();
        mContext = this;

        //        drawerFragment = new DrawerFragment();
        //        getSupportFragmentManager().beginTransaction()
        //                .add(R.id.drawer_content, drawerFragment).commit();

        openDrawerImg.setVisibility(View.GONE);

        initBottomBar();
    }

    private void initBottomBar() {
        bottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor(R.color.bottom_img)
                .setBarBackgroundColor(R.color.whitesmoke);
        bottomBar.addItem(new BottomNavigationItem(R.drawable.home, R.string.home))
                .addItem(new BottomNavigationItem(R.drawable.cat_home, R.string.contact))
                .addItem(new BottomNavigationItem(R.drawable.user_home, R.string.user))
                .initialise();
        setContent(CONTENT_HOME);
        bottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        setContent(CONTENT_HOME);
                        break;
                    case 1:
                        setContent(CONTENT_CONTACT);
                        break;
                    case 2:
                        setContent(CONTENT_USER);
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    public void setContent(int contentHome) {
        switch (contentHome) {
            case CONTENT_HOME:
                String home_str = getResources().getString(R.string.home);
                homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HOME_TAG);
                hideFragment(HOME_TAG);
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, homeFragment, HOME_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(homeFragment).commitNow();
                }
                break;
            case CONTENT_CONTACT:
                String contact_str = getResources().getString(R.string.contact);
                contactFragment = (ContactFragment) getSupportFragmentManager().findFragmentByTag(CONTACT_TAG);
                hideFragment(CONTACT_TAG);
                if (contactFragment == null) {
                    contactFragment = ContactFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, contactFragment, CONTACT_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(contactFragment).commitNow();
                }

                break;
            case CONTENT_USER:
                String user_str = getResources().getString(R.string.user);
                userFragment = (UserFragment) getSupportFragmentManager().findFragmentByTag(USER_TAG);
                hideFragment(USER_TAG);
                if (userFragment == null) {
                    userFragment = UserFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, userFragment, USER_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(userFragment).commitNow();
                }
                break;

        }

    }

    private void hideFragment(String tag) {

        if (homeFragment != null && tag != HOME_TAG) {
            getSupportFragmentManager().beginTransaction().hide(homeFragment).commitNow();
        }
        if (contactFragment != null && tag != CONTACT_TAG) {
            getSupportFragmentManager().beginTransaction().hide(contactFragment).commitNow();

        }
        if (userFragment != null && tag != USER_TAG) {
            getSupportFragmentManager().beginTransaction().hide(userFragment).commitNow();
        }
    }

    Thread thread;
    String apkName = "";

    public void getApk(int index) {

        if (index == 1) {
            //矿山
            apkName = "kuangshan170303.apk";

        } else if (index == 2) {
            //旅游
            apkName = "XiananLvyou20170313.apk";
        } else if (index == 3) {
            //治安
            apkName = "Sobey_Android_V1.1.8_Build20170223_1756_signed.apk";
        } else {
            //智慧新安
            apkName = "xinan_eGovaMobileMain.apk";
        }
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Message message = new Message();
                    message.what = 2;
                    mHandler.sendMessage(message);
                    File file = new File(Environment.getExternalStorageDirectory() + "/" + apkName);
                    if (file.exists()) {
                        Message message2 = new Message();
                        message2.what = 1;
                        mHandler.sendMessage(message2);
                    } else {
                        copyBigDataToSD(apkName, Environment.getExternalStorageDirectory() + "/" + apkName);
                    }
                } catch (IOException e) {
                    Log.i("gqf", "while" + e.toString());
                    Message message = new Message();
                    message.what = 3;
                    mHandler.sendMessage(message);
                }
            }
        });
        thread.start();

    }

    private void copyBigDataToSD(String apkName, String strOutFileName) throws IOException {
        InputStream myInput;
        OutputStream myOutput = new FileOutputStream(strOutFileName);
        myInput = this.getAssets().open(apkName);
        byte[] buffer = new byte[1024];
        int length = myInput.read(buffer);
        while (length > 0) {
            myOutput.write(buffer, 0, length);
            length = myInput.read(buffer);
            Log.i("gqf", "while" + length);
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();
        Message message = new Message();
        message.what = 1;
        mHandler.sendMessage(message);

    }

    public void loadStart() {
        homeFragment.showLoading(0);

    }

    public void loadEnd() {
        apkName = "";
        homeFragment.showLoading(1);
    }

    public void loadError() {
        Toast.makeText(getApplicationContext(), "加载apk失败", Toast.LENGTH_SHORT);
        loadEnd();
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                final String name = apkName;
                loadEnd();
                new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("加载插件成功")
                        .setContentText("是否去安装插件?")
                        .setCancelText("取消安装")
                        .setConfirmText("继续安装")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                                intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/" + name)), "application/vnd.android.package-archive");
                                startActivity(intent);
                                sDialog.dismiss();
                            }
                        })
                        .show();
            } else if (msg.what == 2) {
                loadStart();
            } else if (msg.what == 3) {
                loadError();
            }
        }
    };
    //退出时的时间
    private long mExitTime;

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {

            Toast.makeText(MainActivity.this, "再按一次退出智慧新安", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {

            //            MyConfig.clearSharePre(this, "users");
            ((BaseApplication) getApplication()).exit();
        }
    }

    public void setSystemBarColor(int id, boolean isHasBack) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //此处可以重新指定状态栏颜色
            tintManager.setStatusBarTintResource(id);
        } else {
            if (toolbar != null) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) toolbar.getLayoutParams();
                lp.height = DisplayUtil.dip2px(this, getResources().getDimension(R.dimen.bigxmdp));
                toolbar.setLayoutParams(lp);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
        compositeSubscription.unsubscribe();
    }

    @OnClick(R.id.open_drawer_img)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, CaptureActivity.class));
    }
}
