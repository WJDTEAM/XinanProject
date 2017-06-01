package tqm.bianfeng.com.xinanproject.travel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 */

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<String> datas;
    private final LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;
    CompositeSubscription compositeSubscription;

    int [] bg_id={R.drawable.travelslider01,R.drawable.travelslider02,R.drawable.travelslider03,R.drawable.travelslider04,R.drawable.travelslider05,R.drawable.travelslider06};
    String [] name={"龙潭大峡谷","黛眉山","千唐志斋","荆紫仙山","新安汉函谷关","有生工矿游景区"};

    public String getDataItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    public WeatherAdapter(Context mContext, List<String> mDatas) {
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
        return R.layout.scenic_spot_weather_list_item;
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
        mHolder.scenicSpotBgImage.setImageResource(bg_id[position]);
        mHolder.scenicSpotNameTxt.setText(name[position]);

    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface MyItemClickListener {
        public void OnClickListener(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.scenic_spot_bg_image)
        KenBurnsView scenicSpotBgImage;
        @BindView(R.id.scenic_spot_weather_image)
        ImageView scenicSpotWeatherImage;
        @BindView(R.id.scenic_spot_temperature_txt)
        TextView scenicSpotTemperatureTxt;
        @BindView(R.id.scenic_spot_weather_txt)
        TextView scenicSpotWeatherTxt;
        @BindView(R.id.scenic_spot_aqi_txt)
        TextView scenicSpotAqiTxt;
        @BindView(R.id.scenic_spot_aqi_level_txt)
        TextView scenicSpotAqiLevelTxt;
        @BindView(R.id.scenic_spot_updata_time_txt)
        TextView scenicSpotUpdataTimeTxt;
        @BindView(R.id.scenic_spot_name_txt)
        TextView scenicSpotNameTxt;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}