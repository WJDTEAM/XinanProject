package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.travel.adapter.WeatherAdapter;

/**
 * Created by johe on 2017/5/19.
 */

public class TravelWeatherListActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scenic_spot_name_txt)
    TextView scenicSpotNameTxt;
    @BindView(R.id.weather_list)
    RecyclerView weatherList;

    List<String> datas;

    WeatherAdapter weatherAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_weather_list);
        ButterKnife.bind(this);
        setToolbar(toolbar, "景区天气", true,R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        datas=new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            datas.add(i+"");
        }
        initList();



    }
    public void initList(){
        weatherAdapter=new WeatherAdapter(this,datas);
        weatherList.setLayoutManager(new LinearLayoutManager(this));
        weatherList.setAdapter(weatherAdapter);
    }
}
