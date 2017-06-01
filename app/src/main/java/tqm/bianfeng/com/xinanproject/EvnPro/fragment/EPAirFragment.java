package tqm.bianfeng.com.xinanproject.EvnPro.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/22.
 * 空气监测
 */

public class EPAirFragment extends BaseFragment{
    public static EPAirFragment newInstance() {
        EPAirFragment fragment = new EPAirFragment();

        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ep_air, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
