package tqm.bianfeng.com.xinanproject.chengguan;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.chengguan.adapter.HightEventAdapter;
import tqm.bianfeng.com.xinanproject.chengguan.adapter.MonthEventAdapter;

/**
 * Created by johe on 2017/5/19.
 */

public class ChengGuanActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.high_incidence_event_list)
    RecyclerView highIncidenceEventList;
    @BindView(R.id.month_event_pie_chart)
    PieChartView monthEventPieChart;
    @BindView(R.id.month_event_list)
    RecyclerView monthEventList;
    @BindView(R.id.event_type1)
    TextView eventType1;
    @BindView(R.id.event_type2)
    TextView eventType2;
    @BindView(R.id.event_type_pro)
    ProgressBar eventTypePro;
    @BindView(R.id.horizontalchart)
    LineChartView horizontalchart;

    HightEventAdapter hightEventAdapter;
    MonthEventAdapter monthEventAdapter;
    @BindView(R.id.logo_img)
    ImageView logoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengguan);
        ButterKnife.bind(this);
        setToolbar(toolbar, "", true, R.color.colorPrimary);
        logoImg.setImageResource(R.drawable.ic_chengguan_logo);
        toolbar.setBackgroundResource(R.color.chengguan_bg);
        initChat(horizontalchart);
        initHightEvent();
        initPieChat();
    }

    public void initHightEvent() {
        List<String> datas = new ArrayList<>();
        datas.add("ss");
        datas.add("ss");
        datas.add("ss");
        datas.add("ss");
        datas.add("ss");
        hightEventAdapter = new HightEventAdapter(this, datas);
        highIncidenceEventList.setLayoutManager(new GridLayoutManager(this, 2));
        highIncidenceEventList.setAdapter(hightEventAdapter);
    }

    //饼状图
    public void initPieChat() {
        int numValues = 4;
        int[] color = {R.color.chengguan_red, R.color.chengguan_yellow, R.color.chengguan_green, R.color.chengguan_blue};

        List<Integer> num = new ArrayList<>();
        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            num.add((int) (Math.random() * 30) + 15);
            SliceValue sliceValue = new SliceValue(
                    num.get(i), getResources().getColor(color[i]));
            values.add(sliceValue);
        }
        PieChartData piedata = new PieChartData(values);
        piedata.setHasLabels(true);
        piedata.setHasLabelsOnlyForSelected(false);
        piedata.setHasLabelsOutside(true);
        piedata.setHasCenterCircle(true);

        monthEventPieChart.setPieChartData(piedata);
        monthEventPieChart.setCircleFillRatio(0.7f);//设置放大缩小范围
        List<String> datas = new ArrayList<>();
        datas.add("ss");
        datas.add("ss");
        datas.add("ss");
        datas.add("ss");
        monthEventAdapter = new MonthEventAdapter(this, datas);
        monthEventAdapter.setNum(num);
        monthEventList.setLayoutManager(new GridLayoutManager(this, 2));
        monthEventList.setAdapter(monthEventAdapter);

    }

    //趋势分析
    public void initChat(LineChartView lineChartView) {
        int numValues = 29;
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<AxisValue> axisValues2 = new ArrayList<AxisValue>();
        List<PointValue> values = new ArrayList<PointValue>();
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numValues; ++i) {
            float hot = (float) Math.random() * 10 + 45;
            PointValue pointValue = new PointValue(i, hot);
            pointValue.setLabel((int) hot + "起");

            values.add(pointValue);//折线图数据点

            //axisValues2.add(new AxisValue(i).setLabel(i*2 + "℃"));

            axisValues.add(new AxisValue(i).setLabel((i+1) + "日"));//折线图时间轴


            Line line = new Line(values);//初始化折线
            line.setColor(ChartUtils.COLOR_GREEN);//设置折线颜色
            line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.DIAMOND）
            line.setCubic(true);//曲线是否平滑，即是曲线还是折线
            line.setFilled(false);//是否填充曲线的面积
            line.setHasLabels(true);//曲线的数据坐标是否加上备注
            //      line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
            line.setHasLines(true);//是否用线显示。如果为false 则没有曲线只有点显示
            line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示（每个数据点都是个大的圆点）
            line.setHasLabels(true);
            lines.add(line);

        }
        for (int i = 0; i < 40; ++i) {
            axisValues2.add(new AxisValue(i).setLabel(i + "℃"));//折线图温度轴
        }
        LineChartData data = new LineChartData(lines);
        //设置底部表格线
        data.setAxisXBottom(new Axis(axisValues)
        );
        //data.setAxisYLeft(new Axis(axisValues2));

        lineChartView.setLineChartData(data);//视图添加数据
        lineChartView.setScrollEnabled(true);
        lineChartView.setViewportCalculationEnabled(false);
        lineChartView.setZoomEnabled(false);
        Viewport viewport = new Viewport(0, 100, 24, 0);//初始化显示位置
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
    }

}
