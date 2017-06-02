package tqm.bianfeng.com.xinanproject.chengguan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.CustomView.CircleView;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/6/1.
 */

public class HightEventListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;
    CompositeSubscription compositeSubscription;

    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public HightEventListAdapter(Context mContext, List<String> mDatas) {
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
        return R.layout.hight_event_list_item;
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
        mHolder.numTxt.setText(position+1+"");
        mHolder.numTxt.setBackgroundColor(mContext.getResources().getColor(R.color.ep_orange));
        mHolder.hightEventLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.OnClickListener(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface MyItemClickListener {
        public void OnClickListener(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.num_txt)
        CircleView numTxt;
        @BindView(R.id.hight_event_time_txt)
        TextView hightEventTimeTxt;
        @BindView(R.id.hight_event_type_txt)
        TextView hightEventTypeTxt;
        @BindView(R.id.hight_event_add_txt)
        TextView hightEventAddTxt;
        @BindView(R.id.hight_event_lin)
        LinearLayout hightEventLin;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}