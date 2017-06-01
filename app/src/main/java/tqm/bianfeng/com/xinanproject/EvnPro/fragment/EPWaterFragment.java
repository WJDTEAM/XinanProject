package tqm.bianfeng.com.xinanproject.EvnPro.fragment;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/5/22.
 * 水质量
 */

public class EPWaterFragment extends BaseFragment {

    String[] yearTime = {"2017", "2016", "2015", "2014", "2013", "2012"};

    String[] mounthTime = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
    @BindView(R.id.select_year)
    AutoCompleteTextView selectYear;
    @BindView(R.id.select_mounth)
    AutoCompleteTextView selectMounth;

    public static EPWaterFragment newInstance() {
        EPWaterFragment fragment = new EPWaterFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ep_water, container, false);
        ButterKnife.bind(this, view);
        initSelect();
        return view;
    }
    public void initSelect(){
        ArrayAdapter<String> autoadapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_dropdown_item, yearTime);
        selectYear.setAdapter(autoadapter);
        selectYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击显示
                selectYear.showDropDown();
            }
        });
        selectYear.setInputType(InputType.TYPE_NULL);
        selectYear.setKeyListener(null);
        selectYear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        ArrayAdapter<String> autoadapter2 = new ArrayAdapter<String>(getActivity(), R.layout.simple_dropdown_item, mounthTime);
        selectMounth.setAdapter(autoadapter2);
        selectMounth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击显示
                selectMounth.showDropDown();
            }
        });
        selectMounth.setInputType(InputType.TYPE_NULL);
        selectMounth.setKeyListener(null);
        selectMounth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
