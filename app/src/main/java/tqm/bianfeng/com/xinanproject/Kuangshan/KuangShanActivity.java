package tqm.bianfeng.com.xinanproject.Kuangshan;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.Kuangshan.fragment.AddressFragment;
import tqm.bianfeng.com.xinanproject.Kuangshan.fragment.Datafragment;
import tqm.bianfeng.com.xinanproject.Kuangshan.fragment.MessageFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/24.
 */

public class KuangShanActivity extends BaseActivity {

    private static final int ADD_EP = 1;
    private static final int DATA_EP = 2;
    private static final int MSG_EP = 3;
    private static final String ADD_TAG = "ADD_TAG";
    private static final String DATA_TAG = "DATA_TAG";
    private static final String MSG_TAG = "MSG_TAG";


    @BindView(R.id.logo_img)
    ImageView logoImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contiar)
    FrameLayout contiar;
    @BindView(R.id.address_lin)
    LinearLayout addressLin;
    @BindView(R.id.data_lin)
    LinearLayout dataLin;
    @BindView(R.id.message_lin)
    LinearLayout messageLin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuangshan);
        ButterKnife.bind(this);
        setToolbar(toolbar, "", true, R.color.kuangshan_bg);
        toolbar.setBackgroundResource(R.color.kuangshan_bg);
        logoImg.setImageResource(R.drawable.ic_kuangshan_logo);
        addressLin.setSelected(true);
        setSelectBg(ADD_EP);
        setContent(ADD_EP);
    }

    @OnClick({R.id.address_lin, R.id.data_lin, R.id.message_lin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.address_lin:
                setSelectBg(ADD_EP);
                setContent(ADD_EP);
                break;
            case R.id.data_lin:
                setSelectBg(DATA_EP);
                setContent(DATA_EP);
                break;
            case R.id.message_lin:
                setSelectBg(MSG_EP);
                setContent(MSG_EP);
                break;
        }
    }

    AddressFragment addressFragment;
    Datafragment datafragment;
    MessageFragment messageFragment;
    public void setContent(int contentHome) {
        switch (contentHome) {
            case ADD_EP:
                addressFragment = (AddressFragment) getSupportFragmentManager().findFragmentByTag(ADD_TAG);
                hideFragment(ADD_TAG);
                if (addressFragment == null) {
                    addressFragment = AddressFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contiar, addressFragment, ADD_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(addressFragment).commitNow();
                }
                break;
            case DATA_EP:
                datafragment = (Datafragment) getSupportFragmentManager().findFragmentByTag(DATA_TAG);
                hideFragment(DATA_TAG);
                if (datafragment == null) {
                    datafragment = Datafragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contiar, datafragment, DATA_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(datafragment).commitNow();
                }
                break;
            case MSG_EP:
                messageFragment = (MessageFragment) getSupportFragmentManager().findFragmentByTag(MSG_TAG);
                hideFragment(MSG_TAG);
                if (messageFragment == null) {
                    messageFragment = MessageFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contiar, messageFragment, MSG_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(messageFragment).commitNow();
                }
                break;

        }

    }
    private void hideFragment(String tag) {
        if (addressFragment != null && tag != ADD_TAG) {
            getSupportFragmentManager().beginTransaction().hide(addressFragment).commitNow();
        }
        if (datafragment != null && tag != DATA_TAG) {
            getSupportFragmentManager().beginTransaction().hide(datafragment).commitNow();
        }
        if (messageFragment != null && tag != MSG_TAG) {
            getSupportFragmentManager().beginTransaction().hide(messageFragment).commitNow();
        }

    }
    public void setSelectBg(int index){
        addressLin.setSelected(false);
        dataLin.setSelected(false);
        messageLin.setSelected(false);
        switch (index){
            case ADD_EP:
                addressLin.setSelected(true);
                break;
            case DATA_EP:
                dataLin.setSelected(true);
                break;
            case MSG_EP:
                messageLin.setSelected(true);
                break;

        }

    }
}
