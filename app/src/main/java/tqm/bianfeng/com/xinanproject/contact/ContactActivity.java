package tqm.bianfeng.com.xinanproject.contact;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tqm.bianfeng.com.xinanproject.Base.BaseActivity;
import tqm.bianfeng.com.xinanproject.CustomView.SideBar;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.contact.adapter.ContactActivityAdapter;

/**
 * Created by johe on 2017/5/27.
 */

public class ContactActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.all_phone_list)
    RecyclerView allPhoneList;
    @BindView(R.id.all_city_sidebar)
    SideBar allCitySidebar;


    ContactActivityAdapter contactActivityAdapter;

    String phones="电话号码查询 /114 ,报警电话 /110 ,火警 /119 ,急救中心/ 120 ,电话故障/ 112 ,报时/ 117 ,天气预报 /121 ,国际长途查询 /106 ,国际人工长途电话/ 103 ,国际直拨受话人付费电话 /108 ,中国邮政储蓄银行/ 95580 ,国内邮政特快专递/ 11185 ,道路交通事故报警 /122 ,国内邮政编码查询 /184 ,电话帐务/ 20170,邮政 /11185 ,供水/ 96303 ,煤气抢修 /5053000 ,劳动保障咨询电话/12333 ,地税国税电话/ 12366 ,邮政储蓄/96170 ,中国电信综合服务 /10000 ,中国联通客服热线 /10010 ,中国移动客服热线 /10086 ,移动彩铃服务 /12530 ,移动长途优惠/ 12593 ,联通客户服务/ 10010 ,联通话费查询/ 10011 ,网通 /10060 ,铁通 /10050 ,工商银行/ 95588 ,农业银行 /95599 ,中国银行 /95566 ,建设银行 /95533 ,兴业银行 /95561 ,招商银行/ 95555 ,交通银行/ 95559 ,华夏银行 /95577 ,商业银行 /88998888 ,太平洋保险/ 95500 ,中国人寿保险 /95519 ,中国平安保险/95511 ,泰康人寿/ 95522 ,新华人寿 /95567 ,虚拟专用网业务 /600 ,法律 /12348 ,彩票/ 17987 ,消费者申诉举报电话/ 12315 ,价格监督举报 /12358 ,质量监督电话/ 12365 ,机构编制违规举报热线 /12310 ,环保局监督电话 /12369 ,水上求救专用电话 /12395 ,天气预报 /12121,报时服务/12117 ,森林火警 /95119 ,红十字会急救台 /999 ,供电局/ 95598 ,文化市场综合执法 /12318 ,税务局通用电话 /12366 ,中国电信IP电话卡 /17900 ,中国联通IP号码/ 17911 ,中国移动IP号码 /17951,公交投诉 /63881333,客运投诉 /68986439,房管局投诉 /67182737,市消协投诉/ 12315,市煤气投诉 /68983383,自来水投诉 /61600111,市电业局投诉 /95598";
    List<String> data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        setToolbar(toolbar, "公众电话", true, R.color.colorPrimary);

       String [] phone=phones.split(",");

        data=new ArrayList<>();
        for(String s:phone){
            data.add(s);
        }
        initList();

    }
    public void initList(){
        contactActivityAdapter=new ContactActivityAdapter(this,data);
        allPhoneList.setLayoutManager(new LinearLayoutManager(this));
        allPhoneList.setAdapter(contactActivityAdapter);
    }

}
