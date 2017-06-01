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
import tqm.bianfeng.com.xinanproject.Kuangshan.adapter.KuangshanDataAdapter;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/24.
 */

public class Datafragment extends BaseFragment {

    @BindView(R.id.data_list)
    RecyclerView dataList;

    List<String > datas;
    KuangshanDataAdapter kuangshanDataAdapter;
    public static Datafragment newInstance() {
        Datafragment fragment = new Datafragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kuangshan_data, container, false);
        ButterKnife.bind(this, view);
        initData();
        initList();
        return view;
    }

    public void initData(){
        datas=new ArrayList<>();
        for(int i=0;i<3;i++){
            datas.add(""+i);
        }
    }
    public void initList(){
        kuangshanDataAdapter=new KuangshanDataAdapter(getActivity(),datas);
        dataList.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList.setAdapter(kuangshanDataAdapter);
    }
}
