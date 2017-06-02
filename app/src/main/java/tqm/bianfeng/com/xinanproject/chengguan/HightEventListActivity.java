package tqm.bianfeng.com.xinanproject.chengguan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.CustomView.AutoHeightLayoutManager;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.chengguan.adapter.HightEventListAdapter;

/**
 * Created by johe on 2017/6/1.
 */

public class HightEventListActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hight_event_list)
    RecyclerView hightEventList;
    @BindView(R.id.previous_page_txt)
    TextView previousPageTxt;
    @BindView(R.id.page_num_txt)
    TextView pageNumTxt;
    @BindView(R.id.next_page_txt)
    TextView nextPageTxt;
    @BindView(R.id.select_page)
    AutoCompleteTextView selectPage;
    @BindView(R.id.all_page_num_txt)
    TextView allPageNumTxt;

    HightEventListAdapter hightEventListAdapter;
    @BindView(R.id.rotate_header_web_view_frame)
    PtrClassicFrameLayout mPtrFrame;
    @BindView(R.id.scrollview)
    ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hight_event_list);
        ButterKnife.bind(this);
        setToolbar(toolbar, "今日高发事件", true, R.color.colorPrimary);
        initList();
        initPtr();
    }

    public void initPtr() {
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame,
                                             View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,
                        scrollview, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //设置两秒后闭合
                        mPtrFrame.refreshComplete();

                    }
                }, 2000);
            }

        });
        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
    }

    public void initList() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            data.add("s");
        }
        hightEventListAdapter = new HightEventListAdapter(this, data);
        hightEventListAdapter.setOnItemClickListener(new HightEventListAdapter.MyItemClickListener() {
            @Override
            public void OnClickListener(int position) {
                startActivity(new Intent(HightEventListActivity.this, HightEventItemActivity.class));

            }
        });
        hightEventList.setLayoutManager(new AutoHeightLayoutManager(this));
        hightEventList.setAdapter(hightEventListAdapter);
    }

    @OnClick({R.id.previous_page_txt, R.id.next_page_txt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.previous_page_txt:
                break;
            case R.id.next_page_txt:
                break;
        }
    }
}
