package tqm.bianfeng.com.xinanproject.EvnPro;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.EvnPro.fragment.EPAirFragment;
import tqm.bianfeng.com.xinanproject.EvnPro.fragment.EPDetectionFragment;
import tqm.bianfeng.com.xinanproject.EvnPro.fragment.EPPollutionFragment;
import tqm.bianfeng.com.xinanproject.EvnPro.fragment.EPWaterFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/22.
 * 智慧环保
 */

public class EvnProActivity extends BaseActivity {

    private static final int AIR_EP = 1;
    private static final int DETECTION_EP = 2;
    private static final int POLLUTION_EP = 3;
    private static final int WATER_EP = 4;
    private static final String AIR_TAG = "AIR_TAG";
    private static final String DETECTION_TAG = "DETECTION_TAG";
    private static final String POLLUTION_TAG = "POLLUTION_TAG";
    private static final String WATER_TAG = "WATER_TAG";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ep_air_lin)
    LinearLayout epAirLin;
    @BindView(R.id.ep_detection_lin)
    LinearLayout epDetectionLin;
    @BindView(R.id.ep_pollution_lin)
    LinearLayout epPollutionLin;
    @BindView(R.id.ep_water_lin)
    LinearLayout epWaterLin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evn_pro);
        ButterKnife.bind(this);
        epAirLin.setSelected(true);
        setToolbar(toolbar,"",true,R.color.ep_orange);
        setContent(AIR_EP);
    }

    @OnClick({R.id.ep_air_lin, R.id.ep_detection_lin, R.id.ep_pollution_lin, R.id.ep_water_lin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ep_air_lin:
                setSelectBg(AIR_EP);
                setContent(AIR_EP);
                break;
            case R.id.ep_detection_lin:
                setSelectBg(DETECTION_EP);
                setContent(DETECTION_EP);
                break;
            case R.id.ep_pollution_lin:
                setSelectBg(POLLUTION_EP);
                setContent(POLLUTION_EP);
                break;
            case R.id.ep_water_lin:
                setSelectBg(WATER_EP);
                setContent(WATER_EP);
                break;
        }
    }

    EPAirFragment epAirFragment;
    EPDetectionFragment epDetectionFragment;
    EPPollutionFragment epPollutionFragment;
    EPWaterFragment epWaterFragment;
    public void setContent(int contentHome) {
        switch (contentHome) {
            case AIR_EP:
                epAirFragment = (EPAirFragment) getSupportFragmentManager().findFragmentByTag(AIR_TAG);
                hideFragment(AIR_TAG);
                if (epAirFragment == null) {
                    epAirFragment = EPAirFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, epAirFragment, AIR_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(epAirFragment).commitNow();
                }
                break;
            case DETECTION_EP:
                epDetectionFragment = (EPDetectionFragment) getSupportFragmentManager().findFragmentByTag(DETECTION_TAG);
                hideFragment(DETECTION_TAG);
                if (epDetectionFragment == null) {
                    epDetectionFragment = EPDetectionFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, epDetectionFragment, DETECTION_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(epDetectionFragment).commitNow();
                }
                break;
            case POLLUTION_EP:
                epPollutionFragment = (EPPollutionFragment) getSupportFragmentManager().findFragmentByTag(POLLUTION_TAG);
                hideFragment(POLLUTION_TAG);
                if (epPollutionFragment == null) {
                    epPollutionFragment = EPPollutionFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, epPollutionFragment, POLLUTION_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(epPollutionFragment).commitNow();
                }
                break;
            case WATER_EP:
                epWaterFragment = (EPWaterFragment) getSupportFragmentManager().findFragmentByTag(WATER_TAG);
                hideFragment(WATER_TAG);
                if (epWaterFragment == null) {
                    epWaterFragment = EPWaterFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_frag, epWaterFragment, WATER_TAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(epWaterFragment).commitNow();
                }
                break;
        }

    }
    private void hideFragment(String tag) {
        if (epAirFragment != null && tag != AIR_TAG) {
            getSupportFragmentManager().beginTransaction().hide(epAirFragment).commitNow();
        }
        if (epDetectionFragment != null && tag != DETECTION_TAG) {
            getSupportFragmentManager().beginTransaction().hide(epDetectionFragment).commitNow();
        }
        if (epPollutionFragment != null && tag != POLLUTION_TAG) {
            getSupportFragmentManager().beginTransaction().hide(epPollutionFragment).commitNow();
        }
        if (epWaterFragment != null && tag != WATER_TAG) {
            getSupportFragmentManager().beginTransaction().hide(epWaterFragment).commitNow();
        }
    }
    public void setSelectBg(int index){
        epAirLin.setSelected(false);
        epDetectionLin.setSelected(false);
        epPollutionLin.setSelected(false);
        epWaterLin.setSelected(false);
        switch (index){
            case AIR_EP:
                epAirLin.setSelected(true);
                break;
            case DETECTION_EP:
                epDetectionLin.setSelected(true);
                break;
            case POLLUTION_EP:
                epPollutionLin.setSelected(true);
                break;
            case WATER_EP:
                epWaterLin.setSelected(true);
                break;
        }

    }

}
