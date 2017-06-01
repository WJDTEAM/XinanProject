package tqm.bianfeng.com.xinanproject.contact.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
 * Created by johe on 2017/5/27.
 */

public class ContactActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;
    CompositeSubscription compositeSubscription;
    int[] color = {R.color.travelcoler6, R.color.travelcoler5, R.color.travelcoler4, R.color.travelcoler3, R.color.travelcoler2, R.color.travelcoler1};

    int[] bg_id = {R.drawable.travelslider01, R.drawable.travelslider02, R.drawable.travelslider03, R.drawable.travelslider04, R.drawable.travelslider05, R.drawable.travelslider06};


    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public ContactActivityAdapter(Context mContext, List<String> mDatas) {
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
        return R.layout.contact_list_item;
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
        String [] data=datas.get(position).split("/");
        String name=data[0];
        final String phone=data[1];
        mHolder.toastTxt.setText(name.substring(0, 1));
        mHolder.contactNameTxt.setText(name);


        mHolder.toastTxt.setBackgroundColor(mContext.getResources().getColor(color[position % 6]));
        mHolder.contactLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phone));
                intentPhone.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intentPhone);
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
        @BindView(R.id.toast_txt)
        CircleView toastTxt;
        @BindView(R.id.contact_name_txt)
        TextView contactNameTxt;
        @BindView(R.id.contact_lin)
        LinearLayout contactLin;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}