package tqm.bianfeng.com.xinanproject.travel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 */

public class TouristsNumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;
    CompositeSubscription compositeSubscription;
    int [] color={R.color.chengguan_blue,R.color.chengguan_yellow,R.color.chengguan_green,R.color.progressBg,R.color.progress,R.color.blue_text};
    String [] name={"龙潭大峡谷","黛眉山","千唐志斋","荆紫仙山","新安汉函谷关","有生工矿游景区"};

    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public TouristsNumAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.datas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
        compositeSubscription = new CompositeSubscription();
    }

    public void update(List<String> mDatas) {
        this.datas = mDatas;
        this.notifyDataSetChanged();
    }

    public int getLayout() {
        return R.layout.scenic_spot_num_list_item;
    }
//13924209015 胡
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);
        //View v = mLayoutInflater.inflate(R.layout.my_order_list_item, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener) {
        mItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        initChrt(mHolder.horizontalchart,position);
        mHolder.scenicSpotNameTxt.setText(name[position]);
    }

    public void initChrt(LineChartView lineChartView,int position){
        int numValues = 24;
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<AxisValue> axisValues2 = new ArrayList<AxisValue>();
        List<PointValue> values = new ArrayList<PointValue>();
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numValues; ++i) {
            float hot = (float) Math.random() * 10 + 45;
            PointValue pointValue = new PointValue(i, hot);
            pointValue.setLabel((int) hot + "%");

            values.add(pointValue);//折线图数据点

            //axisValues2.add(new AxisValue(i).setLabel(i*2 + "℃"));

            axisValues.add(new AxisValue(i).setLabel(i + ":00"));//折线图时间轴

            //1475690508

            Line line = new Line(values);//初始化折线
            line.setColor(mContext.getResources().getColor(color[position]));//设置折线颜色
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


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface MyItemClickListener {
        public void OnClickListener(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.horizontalchart)
        LineChartView horizontalchart;
        @BindView(R.id.scenic_spot_name_txt)
        TextView scenicSpotNameTxt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}