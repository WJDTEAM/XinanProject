package tqm.bianfeng.com.xinanproject.Kuangshan.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.Kuangshan.adapter.KuangshanMsgAdapter;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/24.
 */

public class MessageFragment extends BaseFragment {

    List<String> datas;
    KuangshanMsgAdapter kuangshanDataAdapter;
    @BindView(R.id.msg_list)
    RecyclerView msgList;

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kuangshan_msg, container, false);
        ButterKnife.bind(this, view);
        initData();
        initList();
        return view;
    }

    public void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            datas.add("" + i);
        }
    }

    public void initList() {
        kuangshanDataAdapter = new KuangshanMsgAdapter(getActivity(), datas);
        msgList.setLayoutManager(new LinearLayoutManager(getActivity()));
        msgList.setAdapter(kuangshanDataAdapter);
    }
}
