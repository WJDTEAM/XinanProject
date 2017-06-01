package tqm.bianfeng.com.xinanproject.chengguan.adapter;

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
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 * 高发事件Gridadapter
 */

public class HightEventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;
    CompositeSubscription compositeSubscription;

    int [] color={R.color.chengguan_red,R.color.chengguan_yellow,R.color.chengguan_green};
    String[] name = {"道路破损", "乱堆物堆料", "非法广告","私搭乱建","违规户外广告"};

    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public HightEventAdapter(Context mContext, List<String> mDatas) {
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
        return R.layout.chengguan_today_data_list_item;
    }

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
        mHolder.eventNameTxt.setText(name[position]);
        int num= initChrt(mHolder.chart);
        mHolder.eventNumTxt.setText(num+"");
    }

    public int initChrt(ColumnChartView lineChartView) {
        ColumnChartData data;
        boolean hasAxes = false;
        boolean hasAxesNames = true;
        boolean hasLabels = false;
        boolean hasLabelForSelected = false;

        int numSubcolumns = 1;
        int numColumns = 3;
        // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;

        int num=(int)( Math.random() * 50f);

        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue(num/(i+1) + 5,mContext.getResources().getColor( color[i])));
            }

            Column column = new Column(values);
            column.setHasLabels(hasLabels);
            column.setHasLabelsOnlyForSelected(hasLabelForSelected);
            columns.add(column);
        }

        data = new ColumnChartData(columns);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisX.setName("Axis X");
                axisY.setName("Axis Y");
            }
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        lineChartView.setColumnChartData(data);
        return num;
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface MyItemClickListener {
        public void OnClickListener(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_num_txt)
        TextView eventNumTxt;
        @BindView(R.id.event_name_txt)
        TextView eventNameTxt;
        @BindView(R.id.chart)
        ColumnChartView chart;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}