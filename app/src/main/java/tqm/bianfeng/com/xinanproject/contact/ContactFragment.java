package tqm.bianfeng.com.xinanproject.contact;

import android.app.Activity;
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
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.contact.adapter.ContactListAdapter;

/**
 * Created by johe on 2017/5/22.
 */

public class ContactFragment extends BaseFragment {


    @BindView(R.id.contact_list)
    RecyclerView contactList;

    List<String> datas;
    ContactListAdapter contactListAdapter;
    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();

        return fragment;
    }

    public interface mListener {

    }

    private mListener mListener;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (mListener) activity;

    }
    String contact="新安县政府67281324,新安县委67280353,县人大67280373,县政府67281324,县政协67282620,县纪检委67280240,县武装部63349550,县委67280353,县委机要保密局67282612,县委督查室67287189,研究室67281739,组织部67280374,宣传部67280323,县新闻中心67292226,县文明办67289877,统战部67280251,政法委67280788,县信访局67280266,老干部局67280316,党校67262478,县目标办67280329,县法治办67280852,县民政局67281725,县人劳局67281686,县财政局67280349,县审计局67281624,县发改委67291130,县建设局67289600,县房管局67289625,县市政局67289670,县环保局67291207,县机关事务局67282030,县统计局67280314,县安监局67280771,县旅游局67257927,黛眉山世界地质公园67295117,县煤炭局67281625,县教育局67261335,县科技局67280371,县广播电视局67289000,县文化局67280568,千唐志斋博物馆67335699,县卫生局67285502,县计生委67285612,县交通局67283600,县公路局67290108,县农业开发办67291115,县水利局67290615,县农业局67290993,金土地科技示范园67313112,县畜牧局67262550,县林业局65088800,县农机总站67290852";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);
        datas=new ArrayList<>();
        String [] data=contact.split(",");
        for(String s:data){
            datas.add(s);
        }

        initList();
        return view;
    }
    public void initList(){
        contactListAdapter=new ContactListAdapter(getActivity(),datas);
        contactList.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactList.setAdapter(contactListAdapter);
    }

}
