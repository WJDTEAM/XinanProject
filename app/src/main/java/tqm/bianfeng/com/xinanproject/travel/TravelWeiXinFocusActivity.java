package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

import static tqm.bianfeng.com.xinanproject.Home.HomeFragment.piecolor;

/**
 * Created by johe on 2017/5/19.
 */
//微信关注统计
public class TravelWeiXinFocusActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pie_chart)
    PieChartView pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_weixin_focuse);
        ButterKnife.bind(this);

        setToolbar(toolbar,"微信关注统计",true,R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        initPieChart();
    }
    PieChartData piedata;
    public void initPieChart() {
        int numValues = 2;

        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue(
                    (float) Math.random() * 200 + 500, piecolor[i]);
            sliceValue.setLabel((i%2==0?"男":"女" )+ (int) sliceValue.getValue());//设置label
            values.add(sliceValue);
        }

        piedata = new PieChartData(values);
        piedata.setHasLabels(true);
        piedata.setHasLabelsOnlyForSelected(false);
        piedata.setHasLabelsOutside(true);
        piedata.setHasCenterCircle(false);

        pieChart.setPieChartData(piedata);
        pieChart.setCircleFillRatio(0.7f);//设置放大缩小范围
    }

}
