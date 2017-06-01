package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 */
//基础设施统计
public class TravelInfrastructureActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.chart)
    ColumnChartView chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_infrastructure);
        ButterKnife.bind(this);
        setToolbar(toolbar, "基础设施统计", true, R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        generateDefaultData();
    }
    ColumnChartData data;
    int [] color={R.color.light_rad,R.color.travelcoler1,R.color.progressBg};
    private void generateDefaultData() {
        int numSubcolumns = 1;
        int numColumns = 12;
        List<AxisValue> axisValuesX = new ArrayList<AxisValue>();
        List<AxisValue> axisValuesY = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            int c=getResources().getColor(color[i%3]);
            String label="";
            for (int j = 0; j < numSubcolumns; ++j) {

                float numf=0;
                if(i%3==1){
                    numf=250f;
                }else{
                    numf=5f;
                }

                float num=(float) Math.random() * 50 + numf;
                SubcolumnValue subcolumnValue=new SubcolumnValue(num, c);
                subcolumnValue.setLabel((int)num+"");

                values.add(subcolumnValue);
            }
            if(i%3==1){
                axisValuesX.add(new AxisValue(i).setLabel((2014+i/3)+"年"));
            }

            columns.add(new Column(values).setHasLabels(true).setHasLabelsOnlyForSelected(false));
        }

        data = new ColumnChartData(columns);

        data.setAxisXBottom(new Axis(axisValuesX));
        data.setAxisYLeft(new Axis().setHasLines(true));
        chart.setColumnChartData(data);
        // prepare preview data, is better to use separate deep copy for preview chart.
        // set color to grey to make preview area more visible.
    }

}
