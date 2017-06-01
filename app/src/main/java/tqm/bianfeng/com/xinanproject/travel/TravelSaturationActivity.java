package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 */
//景区饱和度
public class TravelSaturationActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_saturation);
        ButterKnife.bind(this);
        setToolbar(toolbar,"各景区饱和度",true,R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
    }

}
