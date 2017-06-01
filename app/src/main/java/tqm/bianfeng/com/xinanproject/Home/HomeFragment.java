package tqm.bianfeng.com.xinanproject.Home;

import android.Manifest;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tqm.bianfeng.com.xinanproject.Activity.HotNewsActivity;
import tqm.bianfeng.com.xinanproject.Activity.TravelActivity;
import tqm.bianfeng.com.xinanproject.Base.BaseFragment;
import tqm.bianfeng.com.xinanproject.CustomView.MarqueeText;
import tqm.bianfeng.com.xinanproject.EvnPro.EvnProActivity;
import tqm.bianfeng.com.xinanproject.Kuangshan.KuangShanActivity;
import tqm.bianfeng.com.xinanproject.R;
import tqm.bianfeng.com.xinanproject.chengguan.ChengGuanActivity;
import tqm.bianfeng.com.xinanproject.contact.ContactActivity;
import tqm.bianfeng.com.xinanproject.network.NetWork;
import tqm.bianfeng.com.xinanproject.pojo.CommonData;
import tqm.bianfeng.com.xinanproject.pojo.Weather;
import tqm.bianfeng.com.xinanproject.pojo.Weather24;
import tqm.bianfeng.com.xinanproject.pojo.Weather24List;
import tqm.bianfeng.com.xinanproject.pojo.WeatherData;
import tqm.bianfeng.com.xinanproject.pojo.WeatherIndex;
import tqm.bianfeng.com.xinanproject.pojo.WeatherPM;
import tqm.bianfeng.com.xinanproject.pojo.ZTList;
import tqm.bianfeng.com.xinanproject.pojo.ZTResult;
import tqm.bianfeng.com.xinanproject.zxing.activity.CaptureActivity;

/**
 * Created by johe on 2017/4/19.
 */

        public class HomeFragment extends BaseFragment {
            Context mContext;
            @BindView(R.id.home_slider)
            SliderLayout homeSlider;

            public final static String[] address = new String[]{"黛眉山", "龙潭峡", "千唐志斋", "荆紫仙山"};
            public final static int[] piecolor = new int[]{ChartUtils.COLOR_RED, ChartUtils.COLOR_ORANGE, ChartUtils.COLOR_GREEN};//饼状图颜色

            int windowwidth;//屏幕宽度
            @BindView(R.id.horizontalchart)
            LineChartView horizontalchart;
            @BindView(R.id.toast_txt)
            TextView toastTxt;
            Weather mWeather;//天气数据
            @BindView(R.id.hot_num)
            TextView hotNum;
            @BindView(R.id.hot_msg)
            MarqueeText hotMsg;
            @BindView(R.id.hot_radio)
            RadioButton hotRadio;
            @BindView(R.id.pm_radio)
            RadioButton pmRadio;
            @BindView(R.id.pie_chart)
            PieChartView pieChart;
            @BindView(R.id.hot_sun)
            ImageView hotSun;
            @BindView(R.id.hot_cloud)
            ImageView hotCloud;
            @BindView(R.id.aqi_num_txt)
            TextView aqiNumTxt;
            @BindView(R.id.aqi_level_txt)
            TextView aqiLevelTxt;
            @BindView(R.id.PM25_txt)
            TextView PM25Txt;
            @BindView(R.id.PM25_progress)
            ProgressBar PM25Progress;
            @BindView(R.id.PM10_txt)
            TextView PM10Txt;
            @BindView(R.id.PM10_progress)
            ProgressBar PM10Progress;
            @BindView(R.id.Lin6)
            LinearLayout Lin6;
            @BindView(R.id.Lin2)
            LinearLayout Lin2;
            @BindView(R.id.Lin3)
            LinearLayout Lin3;
            @BindView(R.id.Lin4)
            LinearLayout Lin4;
            @BindView(R.id.Lin5)
            LinearLayout Lin5;
            @BindView(R.id.Lin1)
            LinearLayout Lin1;
            @BindView(R.id.Lin7)
            LinearLayout Lin7;
            @BindView(R.id.Lin8)
            LinearLayout Lin8;
            @BindView(R.id.Lin9)
            LinearLayout Lin9;
            @BindView(R.id.huanbao_more_txt)
            TextView huanbaoMoreTxt;
            @BindView(R.id.news_more_txt)
            TextView newsMoreTxt;
            @BindView(R.id.new_lin)
            LinearLayout newLin;
            @BindView(R.id.chengguan_more_txt)
            TextView chengguanMoreTxt;
            @BindView(R.id.lvyou_more_txt)
            TextView lvyouMoreTxt;
            @BindView(R.id.Lin10)
            LinearLayout Lin10;
            @BindView(R.id.Lin11)
            LinearLayout Lin11;
            @BindView(R.id.Lin12)
            LinearLayout Lin12;
            private PieChartData piedata;
            Weather24 mWeather24;//24小时天气数据
            WeatherPM mWeatherPM;//空气质量
            int[] hotNumC = {24, 23, 22, 22, 21, 22, 24, 27, 29, 32, 34, 35, 36, 36, 36, 36, 35, 34, 33, 32, 29, 27, 26, 25};

            private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1234;

            public static HomeFragment newInstance() {
                HomeFragment fragment = new HomeFragment();

        return fragment;
    }


    public interface mListener {
        public void getApk(int index);
    }

    private mListener mListener;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (mListener) activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        windowwidth = wm.getDefaultDisplay().getWidth();//屏幕宽度
        //initChat(0);
        init24Weather();//24小时温度
        initWeather();//当前天气
        initZTData();//空气小时数据
        initSilder();//轮播图
        hotRadio.setChecked(true);
        initPieChart();//饼状图
        toastTxt.setText("今日温度 30摄氏度，请避免较长时间阳光直射");
        demoNet();
        initHotChat();
        return view;
    }

    public void demoNet() {

    }

    public void initPieChart() {
        int numValues = 3;

        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue(
                    (float) Math.random() * 30 + 15, piecolor[i]);
            sliceValue.setLabel(address[i] + (int) sliceValue.getValue());//设置label
            values.add(sliceValue);
        }

        piedata = new PieChartData(values);
        piedata.setHasLabels(true);
        piedata.setHasLabelsOnlyForSelected(false);
        piedata.setHasLabelsOutside(true);
        piedata.setHasCenterCircle(true);

        pieChart.setPieChartData(piedata);
        pieChart.setCircleFillRatio(0.7f);//设置放大缩小范围
    }

    public void initSilder() {
        //加载首页轮播图
        TextSliderView textSliderView1 = new TextSliderView(getActivity());
        textSliderView1.image(R.drawable.banner01)
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .description("致书安主持召开党政联席会议");
        homeSlider.addSlider(textSliderView1);

        TextSliderView textSliderView2 = new TextSliderView(getActivity());
        textSliderView2.image(R.drawable.banner02)
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .description("全市林业工作现场会在我县召开");
        homeSlider.addSlider(textSliderView2);

        TextSliderView textSliderView3 = new TextSliderView(getActivity());
        textSliderView3.image(R.drawable.banner03)
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .description("中国·荆紫山");
        homeSlider.addSlider(textSliderView3);

    }

    private LineChartData data;

    public void initChat(int index) {
        if (index == 0) {
            //初始化天气温度折线图
            initHotChat();

        } else {
            //初始化pm2.5数据折线图
            initPMChat();
        }
    }

    private void initPMChat() {

        int numValues = 24;
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<AxisValue> axisValues2 = new ArrayList<AxisValue>();
        List<PointValue> values = new ArrayList<PointValue>();
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numValues; ++i) {
            float hot = (float) Math.random() * 10 + 45;
            PointValue pointValue = new PointValue(i, hot);
            pointValue.setLabel((int) hot + "mz");

            values.add(pointValue);//折线图数据点

            //axisValues2.add(new AxisValue(i).setLabel(i*2 + "℃"));
            if (mWeather24 != null) {
                String sj = mWeather24.getData().getList().get(23 - i).getSj();
                axisValues.add(new AxisValue(i).setLabel(sj.substring(sj.length() - 8, sj.length() - 3)));
            } else {
                axisValues.add(new AxisValue(i).setLabel(i + ":00"));//折线图时间轴
            }

            Line line = new Line(values);//初始化折线
            line.setColor(ChartUtils.COLOR_GREEN);//设置折线颜色
            line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.DIAMOND）
            line.setCubic(true);//曲线是否平滑，即是曲线还是折线
            line.setFilled(false);//是否填充曲线的面积
            line.setHasLabels(true);//曲线的数据坐标是否加上备注
            //      line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
            line.setHasLines(true);//是否用线显示。如果为false 则没有曲线只有点显示
            line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示（每个数据点都是个大的圆点）
            line.setHasLabels(true);
            lines.add(line);

        }
        for (int i = 0; i < 40; ++i) {
            axisValues2.add(new AxisValue(i).setLabel(i + "℃"));//折线图温度轴
        }
        data = new LineChartData(lines);
        //设置底部表格线
        data.setAxisXBottom(new Axis(axisValues)
        );
        //data.setAxisYLeft(new Axis(axisValues2));

        horizontalchart.setLineChartData(data);//视图添加数据
        horizontalchart.setScrollEnabled(true);
        horizontalchart.setViewportCalculationEnabled(false);
        horizontalchart.setZoomEnabled(false);
        Viewport viewport = new Viewport(0, 100, 24, 0);//初始化显示位置
        horizontalchart.setMaximumViewport(viewport);
        horizontalchart.setCurrentViewport(viewport);

    }

    private void initHotChat() {
        //初始化时间轴
        List<Weather24List> mWeather24Lists = new ArrayList<>();
        if (mWeather24 != null) {
            mWeather24Lists = mWeather24.getData().getList();
        }
        List<String> hotTime = new ArrayList<>();

        int numValues = 24;


        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<AxisValue> axisValues2 = new ArrayList<AxisValue>();

        List<PointValue> values = new ArrayList<PointValue>();
        List<Line> lines = new ArrayList<Line>();

        int passTime = 0;
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        Log.i("gqf", year + "/" + month + "/" + date + " " + hour + ":" + minute + ":" + second);


        for (int i = 0; i < numValues; ++i) {
            float hot = 0;

            Log.i("gqf","time"+((hour + i) > 24 ? (hour + i - 24) : (hour + i)));
            hot = hotNumC[((hour + i) > 23 ? (hour + i - 24) : (hour + i))];

            if (i == 0) {
                hotTime.add("现在");
            } else {
                hotTime.add(((hour + i) > 24 ? (hour + i - 24) : (hour + i)) + ":00");
            }

            PointValue pointValue = new PointValue(i, hot);
            pointValue.setLabel((int) hot + "℃");
            values.add(pointValue);//折线图数据点
            //axisValues2.add(new AxisValue(i).setLabel(i*2 + "℃"));

            axisValues.add(new AxisValue(i).setLabel(hotTime.get(i)));//折线图时间轴

            Line line = new Line(values);//初始化折线
            line.setColor(ChartUtils.COLOR_ORANGE);//设置折线颜色
            line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.DIAMOND）
            line.setCubic(true);//曲线是否平滑，即是曲线还是折线
            line.setFilled(false);//是否填充曲线的面积
            line.setHasLabels(true);//曲线的数据坐标是否加上备注
            //      line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
            line.setHasLines(true);//是否用线显示。如果为false 则没有曲线只有点显示
            line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示（每个数据点都是个大的圆点）
            line.setHasLabels(true);
            lines.add(line);

        }
        for (int i = 0; i < numValues; i++) {
            int time = hour + i;
            if (time > 24) {
                time = time - 24;
            }

            hotTime.add((time == hour) ? "现在" : time + "" + ":00");

        }
        for (int i = 0; i < 40; ++i) {
            axisValues2.add(new AxisValue(i).setLabel(i + "℃"));//折线图温度轴
        }
        data = new LineChartData(lines);
        //设置底部表格线
        data.setAxisXBottom(new Axis(axisValues)
        );
        //data.setAxisYLeft(new Axis(axisValues2));

        horizontalchart.setLineChartData(data);//视图添加数据
        horizontalchart.setScrollEnabled(true);
        horizontalchart.setViewportCalculationEnabled(false);
        horizontalchart.setZoomEnabled(false);
        Viewport viewport = new Viewport(0, 40, 24, 0);//初始化显示位置
        horizontalchart.setMaximumViewport(viewport);
        horizontalchart.setCurrentViewport(viewport);
    }

    //获取24小时温度
    public void init24Weather() {
        Subscription subscription = NetWork.getWeather2Service().getMyAttention()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather24>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("gqf", "Throwable" + e.toString());
                    }

                    @Override
                    public void onNext(Weather24 weather24) {
                        if (weather24.getMsg().equals("Sucess")) {
                            mWeather24 = weather24;
                            hotNum.setText(mWeather24.getData().getList().get(0).getQw() + "℃");
                            Log.i("gqf", "onNext" + mWeather24.toString());
                        }
                        initChat(0);
                        getPMdata();
                    }
                });
        compositeSubscription.add(subscription);
    }

    public void getPMdata() {
        Subscription subscription = NetWork.getWeather2Service().getPM()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherPM>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("gqf", "onError" + e.toString());

                    }

                    @Override
                    public void onNext(WeatherPM weatherPM) {
                        Log.i("gqf", "onNext" + weatherPM);
                        if (weatherPM.getMsg().equals("Sucess")) {
                            mWeatherPM = weatherPM;
                            initAQI();
                        }
                    }
                });
        compositeSubscription.add(subscription);
    }

    public void initAQI() {
        aqiNumTxt.setText(mWeatherPM.getData().getAqi());
        //0－50、51－100、101－150、151－200、201－300和大于300六档
        int aqi = Integer.parseInt(mWeatherPM.getData().getAqi());
        if (aqi <= 50) {
            aqiLevelTxt.setText("优");
        } else if (aqi <= 100 && aqi > 50) {
            aqiLevelTxt.setText("良");
        } else if (aqi <= 150 && aqi > 100) {
            aqiLevelTxt.setText("轻度");
        } else if (aqi <= 200 && aqi > 150) {
            aqiLevelTxt.setText("中度");
        } else if (aqi <= 300 && aqi > 200) {
            aqiLevelTxt.setText("重度");
        } else {
            aqiLevelTxt.setText("严重");
        }
        PM25Txt.setText(mWeatherPM.getData().getPm25());
        PM25Progress.setProgress(Integer.parseInt(mWeatherPM.getData().getPm25()));
        PM10Txt.setText(mWeatherPM.getData().getPm10());
        PM10Progress.setProgress(Integer.parseInt(mWeatherPM.getData().getPm10()));

    }

    //获取天气数据
    public void initWeather() {
        Subscription subscription = NetWork.getWeatherService().getMyAttention()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("gqf", "Throwable" + e.toString());
                    }

                    @Override
                    public void onNext(Weather weather) {
                        //Log.i("gqf", "weather" + weather.toString());
                        mWeather = weather;
                        toastTxt.setVisibility(View.VISIBLE);
                        toastTxt.setText("今日" + weather.getResults().get(0).getWeather_data().get(0).getWeather() + "   " +
                                weather.getResults().get(0).getWeather_data().get(0).getWind());

                        String data = weather.getResults().get(0).getWeather_data().get(0).getDate();
                        //hotNum.setText(data.substring(data.length() - 4, data.length() - 1));

                        WeatherData weatherData = weather.getResults().get(0).getWeather_data().get(0);
                        WeatherIndex weatherIndex = weather.getResults().get(0).getIndex().get(2);
                        hotMsg.setText("今日温度" + weatherData.getTemperature() + "，" + weatherIndex.getDes());
                    }
                });
        compositeSubscription.add(subscription);
        animCloud();
    }

    public void initZTData() {
        Subscription subscription = NetWork.getZTService().getPMairhour()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZTResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZTResult ztResult) {
                        Log.i("gqf", "onNext" + ztResult.toString());
                        if (ztResult.getSuccess()) {
                            for (ZTList ztList : ztResult.getData().getList()) {

                            }
                        }

                    }
                });
        compositeSubscription.add(subscription);
    }

    int hotCloudIndex = 1;

    public void animCloud() {
        int start = 0;
        int end = 0;
        if (hotCloudIndex % 2 == 1) {
            start = 20;
            end = 60;
        } else {
            end = 20;
            start = 60;
        }
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                //tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
                hotCloud.layout(curValue, hotCloud.getTop(), hotCloud.getWidth() + curValue, hotCloud.getBottom());
                if ((hotCloudIndex % 2 == 1 && curValue == 60) || (hotCloudIndex % 2 == 0 && curValue == 20)) {
                    hotCloudIndex++;
                    animCloud();
                }
            }
        });
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    public void startOtherActivity(int index) {
        Context context = getActivity();
        String pkgName = "";
        if (index == 1) {
            //矿山
            pkgName = "com.zedainfo.ZedaSmart";
        } else if (index == 2) {
            //旅游
            pkgName = "com.xinan.app";
        } else if (index == 3) {
            //治安
            pkgName = "com.sobey";
        } else {
            //智慧新安
            pkgName = "cn.com.egova.egovamobile";
        }
        //41080773
        Intent intent = null;

        Map<String, String> map = new HashMap<String, String>();
        ComponentName cn = null;
        try {
            String intentName = map.get("IntentName");
            if (index != 3) {
                if (intentName != null) {
                    intent = new Intent(intentName);
                } else {
                    PackageManager pManager = context.getPackageManager();
                    PackageInfo pi = pManager.getPackageInfo(pkgName, 0);
                    Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
                    resolveIntent.setPackage(pi.packageName);
                    List<ResolveInfo> apps = pManager.queryIntentActivities(
                            resolveIntent, 0);
                    ResolveInfo ri = apps.iterator().next();
                    if (ri != null) {
                        intent = new Intent(Intent.ACTION_MAIN);
                        String packageName = ri.activityInfo.packageName;
                        String className = ri.activityInfo.name;
                        cn = new ComponentName(packageName, className);
                        intent.setComponent(cn);
                        // 城阳地区传递给第三方应用账号
                        intent.putExtra("Account", "sd");
                    }
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
            if (index == 1) {
                //矿山
                intent.putExtra("userID", "admin");
                intent.putExtra("userToken", "admin");
                intent.putExtra("userAdd", "222.141.17.77:88");
            } else if (index == 2) {
                //2128308773

                //旅游
                intent.putExtra("server", "127.0.0.1");
                intent.putExtra("port", "8080");
                intent.putExtra("user", "admin");
                intent.putExtra("password", "admin");

            } else if (index == 3) {
                //            //治安
                intent = new Intent("sobey_live");
                intent.putExtra("server", CommonData.Server);
                intent.putExtra("port", CommonData.Port);
                intent.putExtra("user", CommonData.User);
                intent.putExtra("password", CommonData.Password);
                Log.i("gqf", "sobey_live");
            }
            context.startActivity(intent);
        } catch (Exception e) {
            //Toast.makeText(context, "启动第三方应用异常", Toast.LENGTH_LONG).show();
            //提示是否安装apk
            Log.i("gqf", "sobey_live" + e.toString());
            dialogGetApk(index);
        }
    }
    //    新安城管app
    //    package="cn.com.egova.egovamobile"
    //
    //    需传入4个参数

    //
    //    eGovaMobileMain.apk为对接的主程序app
    public void dialogGetApk(final int index) {
        new SweetAlertDialog(getActivity(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("是否加载此功能?")
                .setContentText("安装不需要流量，需等待10秒")
                .setCancelText("取消加载")
                .setConfirmText("开始加载")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            //申请WRITE_EXTERNAL_STORAGE权限
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                        } else {
                            mListener.getApk(index);
                        }
                        sDialog.dismiss();
                    }
                })
                .show();
    }


    int i = 6;//apk加载进度
    SweetAlertDialog pDialog;
    CountDownTimer countDownTimer;

    public void showLoading(int index) {
        if (index == 0) {
            //开始
            pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE)
                    .setTitleText("加载插件中...");
            pDialog.show();
            pDialog.setCancelable(false);
            countDownTimer = new CountDownTimer(1000 * 100, 1000) {
                public void onTick(long millisUntilFinished) {
                    // you can change the progress bar color by ProgressHelper every 800 millis
                    i++;
                    switch (i % 6) {
                        case 0:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                            break;
                        case 1:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));
                            break;
                        case 2:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                            break;
                        case 3:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));
                            break;
                        case 4:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));
                            break;
                        case 5:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));
                            break;
                        case 6:
                            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                            break;
                    }
                }

                public void onFinish() {
                    i = 6;
                }
            }.start();

        } else {
            //结束
            pDialog.dismiss();
            countDownTimer.onFinish();
        }
    }

    Intent intent;

    @OnClick({R.id.Lin10, R.id.Lin11, R.id.Lin12, R.id.Lin7, R.id.Lin8, R.id.Lin9, R.id.huanbao_more_txt, R.id.news_more_txt, R.id.chengguan_more_txt, R.id.lvyou_more_txt, R.id.new_lin, R.id.Lin6, R.id.Lin1, R.id.Lin2, R.id.Lin3, R.id.Lin4, R.id.Lin5, R.id.hot_radio, R.id.pm_radio})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Lin10:
                //扫一扫
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                } else {
                    startActivity(new Intent(getActivity(), CaptureActivity.class));
                }
                break;
            case R.id.Lin11:
                //火车
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.CAR_URL);
                startActivity(intent);
                break;
            case R.id.Lin12:
                //公众电话
                startActivity(new Intent(getActivity(), ContactActivity.class));
                break;
            case R.id.new_lin:
                //新闻
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.HOT_NEWS_URL);
                startActivity(intent);
                break;
            case R.id.Lin1:
                //startOtherActivity(1);
                //矿山
                startActivity(new Intent(getActivity(), KuangShanActivity.class));
                break;
            case R.id.Lin2:
                //startOtherActivity(2);
                startActivity(new Intent(getActivity(), TravelActivity.class));
                break;
            case R.id.Lin3:
                startOtherActivity(3);
                break;
            case R.id.Lin4:
                //城管
                startActivity(new Intent(getActivity(), ChengGuanActivity.class));
                break;
            case R.id.Lin5:
                //webview
                //startActivity(new Intent(getActivity(), EPActivity.class));
                //环保
                startActivity(new Intent(getActivity(), EvnProActivity.class));
                break;
            case R.id.Lin6:
                //新闻
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.HOT_NEWS_URL);
                startActivity(intent);
                break;
            case R.id.hot_radio:
                initChat(0);
                toastTxt.setText("今日温度 30摄氏度，请避免较长时间阳光直射");
                break;
            case R.id.pm_radio:
                initChat(1);
                toastTxt.setText("过去24小时PM2.5指数");
                break;
            case R.id.huanbao_more_txt:
                //智慧环保
                //startActivity(new Intent(getActivity(), EPActivity.class));
                startActivity(new Intent(getActivity(), EvnProActivity.class));
                break;
            case R.id.news_more_txt:
                //新闻
                //startActivity(new Intent(getActivity(), HotNewsActivity.class));
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.HOT_NEWS_URL);
                startActivity(intent);
                break;
            case R.id.chengguan_more_txt:
                //城管
                startActivity(new Intent(getActivity(), ChengGuanActivity.class));
                break;
            case R.id.lvyou_more_txt:
                startActivity(new Intent(getActivity(), TravelActivity.class));
                break;

            case R.id.Lin7:
                //国搜
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.CHINA_SEARCH_URL);
                startActivity(intent);
                break;
            case R.id.Lin8:
                //旅游推荐
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.RECOMMENDATION_URL);
                startActivity(intent);
                break;
            case R.id.Lin9:
                //营养健康
                intent = new Intent(getActivity(), HotNewsActivity.class);
                intent.putExtra("url", HotNewsActivity.NUTRITION_URL);
                startActivity(intent);
                break;

        }
    }


}
