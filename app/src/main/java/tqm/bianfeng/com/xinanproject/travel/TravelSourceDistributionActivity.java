package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.PieChartView;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.CustomView.AutoHeightLayoutManager;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.travel.adapter.TravelSDPieListAdapter;

/**
 * Created by johe on 2017/5/19.
 */
//游客来源分布
public class TravelSourceDistributionActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    String[] name = {"河南", "河北", "山东", "山西", "湖南", "陕西", "广东", "广西", "湖北", "其他"};
    int[] proportion={26, 22, 18, 12, 3, 3, 2, 2, 2, 2};

    int [] color={R.color.travelcoler8,R.color.travelcoler2,R.color.travelcoler5,R.color.travelcoler4,R.color.hot_bg
            ,R.color.travelcoler1,R.color.travelcoler3,R.color.travelcoler7,R.color.travelcoler6,R.color.orange_light};

    @BindView(R.id.pie_chart)
    PieChartView pieChart;
    @BindView(R.id.pie_list)
    RecyclerView pieList;
    @BindView(R.id.pie_lin)
    LinearLayout pieLin;
    @BindView(R.id.chart)
    ColumnChartView chart;
    @BindView(R.id.pie_radio)
    RadioButton pieRadio;
    @BindView(R.id.chart_radio)
    RadioButton chartRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_source_distribution);
        ButterKnife.bind(this);
        setToolbar(toolbar, "游客来源分布", true, R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        pieRadio.setChecked(true);
        initPieChart();
        initlist();
        generateDefaultData();
    }
    ColumnChartData data;
    private void generateDefaultData() {
        int numSubcolumns = 1;
        int numColumns = 10;
        List<AxisValue> axisValuesX = new ArrayList<AxisValue>();
        List<AxisValue> axisValuesY = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            int c=getResources().getColor(color[i]);
            String label="";
            for (int j = 0; j < numSubcolumns; ++j) {
                float num=proportion[i]*12.3f;
                SubcolumnValue subcolumnValue=new SubcolumnValue(num, c);
                subcolumnValue.setLabel((int)num+"");
                values.add(subcolumnValue);
            }
            axisValuesX.add(new AxisValue(i).setLabel(name[i]));

            columns.add(new Column(values).setHasLabels(true).setHasLabelsOnlyForSelected(false));
        }

        data = new ColumnChartData(columns);

        data.setAxisXBottom(new Axis(axisValuesX));
        data.setAxisYLeft(new Axis().setHasLines(true));


        chart.setValueSelectionEnabled(false);
        chart.setColumnChartData(data);

    }
    PieChartData piedata;

    public void initPieChart() {
        int numValues = 10;

        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue(
                    (float)proportion[i], getResources().getColor(color[i]));
            sliceValue.setLabel(proportion[i]+"");//设置label
            values.add(sliceValue);
        }

        piedata = new PieChartData(values);
        piedata.setHasLabels(true);
        piedata.setHasLabelsOnlyForSelected(false);
        piedata.setHasLabelsOutside(false);
        piedata.setHasCenterCircle(false);

        pieChart.setPieChartData(piedata);
        pieChart.setCircleFillRatio(1f);//设置放大缩小范围
    }

    public void initlist(){
        List<String> data=new ArrayList<>();
        for(int i=0;i<10;i++){
            data.add(""+i);
        }
        TravelSDPieListAdapter travelSDPieListAdapter=new TravelSDPieListAdapter(this,data);
        pieList.setLayoutManager(new AutoHeightLayoutManager(this));
        pieList.setAdapter(travelSDPieListAdapter);
    }

    @OnClick({R.id.pie_radio, R.id.chart_radio})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pie_radio:
                showOrHide();
                break;
            case R.id.chart_radio:
                showOrHide();
                break;
        }
    }
    public void showOrHide(){
        if(pieRadio.isChecked()){
            chart.setVisibility(View.GONE);
            pieLin.setVisibility(View.VISIBLE);
        }else{
            chart.setVisibility(View.VISIBLE);
            pieLin.setVisibility(View.GONE);
        }
    }
}
