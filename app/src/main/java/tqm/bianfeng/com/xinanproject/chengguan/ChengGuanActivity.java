package tqm.bianfeng.com.xinanproject.chengguan;

import android.content.Intent;
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
        for (int i = 0; i < 5; ++i) {
            datas.add("ss");
        }
        hightEventAdapter = new HightEventAdapter(this, datas);
        hightEventAdapter.setOnItemClickListener(new HightEventAdapter.MyItemClickListener() {
            @Override
            public void OnClickListener(int position) {
                //跳转高发事件页面
                startActivity(new Intent(ChengGuanActivity.this,HightEventListActivity.class));

            }
        });
        highIncidenceEventList.setLayoutManager(new GridLayoutManager(this, 2));
        highIncidenceEventList.setAdapter(hightEventAdapter);
    }

    //饼状图
    public void initPieChat() {
        int numValues = 10;
        int[] color = {R.color.travelcoler1, R.color.travelcoler2, R.color.travelcoler3, R.color.travelcoler4,R.color.ep_button_text_color
        ,R.color.travelcoler5,R.color.travelcoler6,R.color.travelcoler7,R.color.travelcoler8,R.color.pink_pressed};
        String[] name = {"突发事件", "街面秩序", "宣传广告", "施工管理", "市容环境", "绿化设施", "公共设施", "交通设施", "市容设施", "其他设施"};

        List<Integer> num = new ArrayList<>();
        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            num.add((int) (Math.random() * 10) + 5);
            SliceValue sliceValue = new SliceValue(
                    num.get(i), getResources().getColor(color[i]));
            sliceValue.setLabel(name[i]+ num.get(i));
            values.add(sliceValue);
        }
        PieChartData piedata = new PieChartData(values);
        piedata.setHasLabels(true);
        piedata.setHasLabelsOnlyForSelected(false);
        piedata.setHasLabelsOutside(true);
        piedata.setHasCenterCircle(true);
        piedata.setValueLabelTextSize(10);
        monthEventPieChart.setPieChartData(piedata);
        monthEventPieChart.setCircleFillRatio(0.7f);//设置放大缩小范围


        List<String> datas = new ArrayList<>();
        for (int i = 0; i <10; ++i) {
            datas.add(i+10+"");
        }
        monthEventAdapter = new MonthEventAdapter(this, datas);
        monthEventAdapter.setNum(num);
        monthEventList.setLayoutManager(new GridLayoutManager(this, 4));
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
