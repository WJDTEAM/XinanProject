package tqm.bianfeng.com.xinanproject.travel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/24.
 */

public class TravelSDPieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    int[] color = {R.color.travelcoler8, R.color.travelcoler2, R.color.travelcoler5, R.color.travelcoler4, R.color.hot_bg
            , R.color.travelcoler1, R.color.travelcoler3, R.color.travelcoler7, R.color.travelcoler6, R.color.orange_light};

    String[] name = {"河南", "河北", "山东", "山西", "湖南", "陕西", "广东", "广西", "湖北", "其他"};
    int[] proportion={26, 22, 18, 12, 3, 3, 2, 2, 2, 2};

    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private  MyItemClickListener mItemClickListener;
    CompositeSubscription compositeSubscription;

    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public TravelSDPieListAdapter(Context mContext, List<String> mDatas) {
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
        return R.layout.travel_sd_pielist_item;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);
        //View v = mLayoutInflater.inflate(R.layout.my_order_list_item, parent, false);
        RecyclerView.ViewHolder viewHolder = new  ViewHolder(v);

        return viewHolder;
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener( MyItemClickListener listener) {
        mItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        mHolder.colorView.setBackgroundResource(color[position]);
        mHolder.proportionTxt.setText(proportion[position]+"%");
        mHolder.nameTxt.setText(name[position]);
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface MyItemClickListener {
        public void OnClickListener(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name_txt)
        TextView nameTxt;
        @BindView(R.id.color_view)
        View colorView;
        @BindView(R.id.proportion_txt)
        TextView proportionTxt;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
