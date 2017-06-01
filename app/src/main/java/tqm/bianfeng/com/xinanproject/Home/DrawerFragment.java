package tqm.bianfeng.com.xinanproject.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tqm.bianfeng.com.xinanproject.Activity.HotNewsActivity;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/19.
 */

public class DrawerFragment extends BaseFragment {

    @BindView(R.id.drawer_lin01)
    LinearLayout drawerLin01;
    @BindView(R.id.drawer_lin02)
    LinearLayout drawerLin02;
    @BindView(R.id.drawer_lin03)
    LinearLayout drawerLin03;
    @BindView(R.id.drawer_lin04)
    LinearLayout drawerLin04;
    @BindView(R.id.drawer_lin05)
    LinearLayout drawerLin05;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.drawer_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    Intent intent;
    @OnClick({R.id.drawer_lin01, R.id.drawer_lin02, R.id.drawer_lin03, R.id.drawer_lin04, R.id.drawer_lin05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_lin01:
                intent=new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url",HotNewsActivity.CHINA_SEARCH_URL);
                startActivity(intent);
                break;
            case R.id.drawer_lin02:
                intent=new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url",HotNewsActivity.HOT_NEWS_URL);
                startActivity(intent);
                break;
            case R.id.drawer_lin03:
                intent=new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url",HotNewsActivity.NUTRITION_URL);
                startActivity(intent);
                break;
            case R.id.drawer_lin04:
                intent=new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url",HotNewsActivity.HEALTH_URL);
                startActivity(intent);
                break;
            case R.id.drawer_lin05:
                break;
        }
    }
}
