package tqm.bianfeng.com.xinanproject.Kuangshan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/24.
 */

public class AddressFragment extends BaseFragment {

    public static AddressFragment newInstance() {
        AddressFragment fragment = new AddressFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kuangshan_add, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
