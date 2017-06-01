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
import tqm.bianfeng.com.xinanproject.travel.adapter.TouristsNumAdapter;

/**
 * Created by johe on 2017/5/19.
 */

public class TravelTouristsNumListActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scenic_spot_name_txt)
    TextView scenicSpotNameTxt;
    @BindView(R.id.tourists_num_list)
    RecyclerView touristsNumList;

    List<String> datas;
    TouristsNumAdapter touristsNumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_num_list);
        ButterKnife.bind(this);
        setToolbar(toolbar, "景区流量", true,R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        datas=new ArrayList<>();
        datas.add("ss");
        datas.add("dd");
        datas.add("pp");
        datas.add("ss");
        datas.add("dd");
        datas.add("pp");
        initList();
    }

    public void initList() {
        touristsNumAdapter=new TouristsNumAdapter(this,datas);
        touristsNumList.setLayoutManager(new LinearLayoutManager(this));
        touristsNumList.setAdapter(touristsNumAdapter);
    }
}
