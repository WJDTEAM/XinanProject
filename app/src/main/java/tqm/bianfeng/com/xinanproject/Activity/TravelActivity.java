package tqm.bianfeng.com.xinanproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.adapter.TravelAdapter;
import tqm.bianfeng.com.xinanproject.travel.TravelInfrastructureActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelMonthTrafficActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelSaturationActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelSourceDistributionActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelTouristsNumListActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelTradingActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelWeatherListActivity;
import tqm.bianfeng.com.xinanproject.travel.TravelWeiXinFocusActivity;

/**
 * Created by johe on 2017/5/15.
 * 智慧旅游
 */

public class TravelActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    String[] titles = {"各景区饱和度", "景区实时流量", "月度流量统计", "景区天气简况", "基础设置统计", "游客来源分布", "微信关注统计", "电商交易统计"};
    int[] imageId = {R.drawable.travel01, R.drawable.travel02, R.drawable.travel03, R.drawable.travel04, R.drawable.travel05, R.drawable.travel06, R.drawable.travel07, R.drawable.travel08};
    int[] bgColor = {R.color.travelcoler1, R.color.travelcoler2, R.color.travelcoler3, R.color.travelcoler4, R.color.travelcoler5, R.color.travelcoler6, R.color.travelcoler7, R.color.travelcoler8};


    List<String> datas;
    @BindView(R.id.travel_list)
    RecyclerView travelList;

    TravelAdapter travelAdapter;
    @BindView(R.id.home_slider)
    SliderLayout homeSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        ButterKnife.bind(this);
        datas = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            datas.add(titles[i]);
        }
        setToolbar(toolbar,"",true,R.color.ep_orange);
        travelAdapter = new TravelAdapter(datas, this);
        travelAdapter.setImageId(imageId);
        travelAdapter.setOnItemClickListener(new TravelAdapter.StringClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                switch (postion){
                    case 1:
                        //景区流量实时统计
                        startActivity(new Intent(TravelActivity.this,TravelTouristsNumListActivity.class));
                        break;
                    case 2:
                        //月流量统计
                        startActivity(new Intent(TravelActivity.this,TravelMonthTrafficActivity.class));
                        break;
                    case 3:
                        //景区天气
                        startActivity(new Intent(TravelActivity.this,TravelWeatherListActivity.class));
                        break;
                    case 4:
                        //基础设施统计
                       startActivity(new Intent(TravelActivity.this,TravelInfrastructureActivity.class));
                        break;
                    case 5:
                        //游客来源分布
                        startActivity(new Intent(TravelActivity.this,TravelSourceDistributionActivity.class));
                        break;
                    case 6:
                        //微信关注统计
                        startActivity(new Intent(TravelActivity.this,TravelWeiXinFocusActivity.class));
                        break;
                    case 7:
                        //电商交易统计
                       startActivity(new Intent(TravelActivity.this,TravelTradingActivity.class));
                        break;
                    case 0:
                        //饱和度
                        startActivity(new Intent(TravelActivity.this,TravelSaturationActivity.class));
                        break;
                }

            }
        });
        travelList.setLayoutManager(new GridLayoutManager(this, 2));
        travelList.setAdapter(travelAdapter);
        initImages();
    }

    Integer[] mSlider = {R.drawable.travelslider01, R.drawable.travelslider02, R.drawable.travelslider03};

    //轮播
    public void initImages() {
        int size = mSlider.length;
        for (int i = 0; i < size; i++) {

            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView.image(mSlider[i]).setScaleType(BaseSliderView.ScaleType.Fit);
            homeSlider.addSlider(textSliderView);
        }
    }

}
