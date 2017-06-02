package tqm.bianfeng.com.xinanproject.chengguan;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.R;

/**
 * Created by johe on 2017/6/1.
 */

public class HightEventItemActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hight_event_item);
        ButterKnife.bind(this);
        setToolbar(toolbar, "事件详情", true, R.color.colorPrimary);
    }
}
