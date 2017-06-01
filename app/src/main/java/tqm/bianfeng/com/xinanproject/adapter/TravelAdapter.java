package tqm.bianfeng.com.xinanproject.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/15.
 * 旅游二级页面Gridadapter
 *
 */

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ViewHolder> {

    List<String> datas;
    int[] imageId;
    int[] bgColor = {R.color.travelcoler1, R.color.travelcoler2, R.color.travelcoler3, R.color.travelcoler4, R.color.travelcoler5, R.color.travelcoler6, R.color.travelcoler7, R.color.travelcoler8};

    StringClickListener mItemClickListener;



    public void setImageId(int[] imageId) {
        this.imageId = imageId;

    }

    public void setBgColor(int[] bgColor) {
        this.bgColor = bgColor;
    }

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public int getLayout() {
        return R.layout.travel_item;
    }

    public TravelAdapter(List<String> datas, Context mContext) {
        this.mContext = mContext;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(StringClickListener listener) {
        this.mItemClickListener = listener;
    }


    public interface StringClickListener {
        public void onItemClick(View view, int postion);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(getLayout(), parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.travelText.setText(datas.get(position));
        holder.travelImage.setImageResource(imageId[position]);
        holder.bgLin.setBackgroundColor(mContext.getResources().getColor(bgColor[position]));


        int right = 0;
        int left = 0;
        if (position % 2 == 0) {
            right = 15;
        } else {
            left = 15;
        }
        GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) holder.bgLin.getLayoutParams();
        lp.setMargins(left, 30, right, 0);
        holder.bgLin.setLayoutParams(lp);

        holder.clickLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(null, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    public void setdatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.travel_image)
        ImageView travelImage;
        @BindView(R.id.travel_text)
        TextView travelText;
        @BindView(R.id.click_lin)
        LinearLayout clickLin;
        @BindView(R.id.bg_lin)
        LinearLayout bgLin;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
