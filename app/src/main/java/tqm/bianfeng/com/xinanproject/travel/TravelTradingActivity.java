package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.PieChartView;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

import static tqm.bianfeng.com.xinanproject.Home.HomeFragment.piecolor;

/**
 * Created by johe on 2017/5/19.
 */
//电商交易统计
public class TravelTradingActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scenic_spot_name_txt)
    TextView scenicSpotNameTxt;
    @BindView(R.id.pie_chart)
    PieChartView pieChart;
    @BindView(R.id.chart)
    ColumnChartView chart;

    int [] color={R.color.travelcoler1,R.color.travelcoler4,R.color.travelcoler7};
    int [] num={10,30,20};
    String [] name={"线路","景点","酒店"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_trading);
        ButterKnife.bind(this);
        setToolbar(toolbar, "电商交易统计", true, R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        initPieChart();
        generateDefaultData();
    }
    PieChartData piedata;
    public void initPieChart() {
        int numValues = 3;
        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue(
                    (float) Math.random() * 200 + 500, piecolor[i]);

            sliceValue.setLabel(name[i]+ (int) sliceValue.getValue());//设置label
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
    ColumnChartData data;
    private void generateDefaultData() {
        int numSubcolumns = 1;
        int numColumns = 3;
        List<AxisValue> axisValuesX = new ArrayList<AxisValue>();
        List<AxisValue> axisValuesY = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            int c=getResources().getColor(color[i]);
            String label="";
            for (int j = 0; j < numSubcolumns; ++j) {

                float numf=0;

                SubcolumnValue subcolumnValue=new SubcolumnValue(num[i], c);
                subcolumnValue.setLabel(name[i]+"");

                values.add(subcolumnValue);
            }
            if(i%3==1){
                axisValuesX.add(new AxisValue(i).setLabel((2014+i/3)+"年"));
            }

            columns.add(new Column(values).setHasLabels(true).setHasLabelsOnlyForSelected(false));
        }

        data = new ColumnChartData(columns);

       // data.setAxisXBottom(new Axis(axisValuesX));
        //data.setAxisYLeft(new Axis().setHasLines(true));

        chart.setColumnChartData(data);

        Viewport newViewport=new Viewport(chart.getMaximumViewport().left,50,chart.getMaximumViewport().right,0);
        chart.setMaximumViewport(newViewport);
        chart.setCurrentViewport(newViewport);


        // prepare preview data, is better to use separate deep copy for preview chart.
        // set color to grey to make preview area more visible.
    }

}
