package tqm.bianfeng.com.xinanproject.travel;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.PreviewColumnChartView;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 */
//景区月流量统计
public class TravelMonthTrafficActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.chart)
    ColumnChartView chart;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.chart_preview)
    PreviewColumnChartView previewChart;
    private ColumnChartData data;
    private ColumnChartData previewData;
    int [] color={R.color.light_rad,R.color.progress,R.color.progressBg};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_month_traffic);
        ButterKnife.bind(this);
        setToolbar(toolbar, "月度流量统计", true, R.color.ep_orange);
        toolbar.setBackgroundResource(R.color.ep_orange);
        init();

    }
    public void init(){
        generateDefaultData();

        chart.setColumnChartData(data);

        // Disable zoom/scroll for previewed chart, visible chart ranges depends on preview chart viewport so
        // zoom/scroll is unnecessary.
        chart.setZoomEnabled(false);
        chart.setScrollEnabled(false);
        previewChart.setColumnChartData(previewData);
        previewChart.setViewportChangeListener(new ViewportListener());

        previewX(false);
    }
    private void generateDefaultData() {
        int numSubcolumns = 1;
        int numColumns = 36;
        List<AxisValue> axisValuesX = new ArrayList<AxisValue>();
        List<AxisValue> axisValuesY = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            int c=getResources().getColor(color[i%3]);
            String label="";
            for (int j = 0; j < numSubcolumns; ++j) {
                float num=(float) Math.random() * 50f + 5;
                SubcolumnValue subcolumnValue=new SubcolumnValue(num, c);
                subcolumnValue.setLabel((int)num+"");
                values.add(subcolumnValue);
            }
            if(i%3==1){
                axisValuesX.add(new AxisValue(i).setLabel((1+((i-1)/3))+"月"));
            }

            columns.add(new Column(values).setHasLabels(true).setHasLabelsOnlyForSelected(false));
        }

        data = new ColumnChartData(columns);

        data.setAxisXBottom(new Axis(axisValuesX));
        data.setAxisYLeft(new Axis().setHasLines(true));


        chart.setValueSelectionEnabled(false);
        // prepare preview data, is better to use separate deep copy for preview chart.
        // set color to grey to make preview area more visible.
        previewData = new ColumnChartData(data);
        for (Column column : previewData.getColumns()) {
            for (SubcolumnValue value : column.getValues()) {
                value.setColor(ChartUtils.DEFAULT_DARKEN_COLOR);
            }
        }

    }

    private void previewY() {
        Viewport tempViewport = new Viewport(chart.getMaximumViewport());
        float dy = tempViewport.height() / 4;
        tempViewport.inset(0, dy);
        previewChart.setCurrentViewportWithAnimation(tempViewport);
        previewChart.setZoomType(ZoomType.VERTICAL);
    }

    private void previewX(boolean animate) {
        Viewport tempViewport = new Viewport(chart.getMaximumViewport());
        float dx = tempViewport.width() / 4;
        tempViewport.inset(dx, 0);
        if (animate) {
            previewChart.setCurrentViewportWithAnimation(tempViewport);
        } else {
            previewChart.setCurrentViewport(tempViewport);
        }
        previewChart.setZoomType(ZoomType.HORIZONTAL);
    }

    private void previewXY() {
        // Better to not modify viewport of any chart directly so create a copy.
        Viewport tempViewport = new Viewport(chart.getMaximumViewport());
        // Make temp viewport smaller.
        float dx = tempViewport.width() / 4;
        float dy = tempViewport.height() / 4;
        tempViewport.inset(dx, dy);
        previewChart.setCurrentViewportWithAnimation(tempViewport);
    }

    /**
     * Viewport listener for preview chart(lower one). in {@link #onViewportChanged(Viewport)} method change
     * viewport of upper chart.
     */
    private class ViewportListener implements ViewportChangeListener {

        @Override
        public void onViewportChanged(Viewport newViewport) {
            // don't use animation, it is unnecessary when using preview chart because usually viewport changes
            // happens to often.
            chart.setCurrentViewport(newViewport);
        }

    }

}
