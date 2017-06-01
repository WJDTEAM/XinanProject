package tqm.bianfeng.com.xinanproject.Kuangshan.adapter;

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

public class KuangshanMsgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;
    String[] name = {"恒祥", "郁山", "云顶"};
    CompositeSubscription compositeSubscription;

    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public KuangshanMsgAdapter(Context mContext, List<String> mDatas) {
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
        return R.layout.kuangshan_msg_list_item;
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

        mHolder.msgNameTxt.setText(name[position]);
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface MyItemClickListener {
        public void OnClickListener(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.msg_name_txt)
        TextView msgNameTxt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
