package tqm.bianfeng.com.xinanproject.network;

import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tqm.bianfeng.com.xinanproject.network.api.Weather2Service;
import tqm.bianfeng.com.xinanproject.network.api.WeatherService;
import tqm.bianfeng.com.xinanproject.network.api.ZTService;
import tqm.bianfeng.com.xinanproject.network.url.TargetUrl;


/**
 * Created by wjy on 16/9/1.
 */
public class NetWork {

    private static WeatherService weatherService;
    private static Weather2Service weather2Service;
    private static ZTService ztService;

    public static ZTService getZTService() {
        if (ztService == null) {
            Retrofit retrofit = getZTRetrofit();
            ztService = retrofit.create(ZTService.class);
        }
        return ztService;
    }
    public static WeatherService getWeatherService() {
        if (weatherService == null) {
            Retrofit retrofit = getWeatherRetrofit();
            weatherService = retrofit.create(WeatherService.class);
        }
        return weatherService;
    }
    public static Weather2Service getWeather2Service() {
        if (weather2Service == null) {
            Retrofit retrofit = getWeather2Retrofit();
            weather2Service = retrofit.create(Weather2Service.class);
        }
        return weather2Service;
    }

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static Retrofit getWeatherRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(TargetUrl.url1)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    private static Retrofit getWeather2Retrofit() {

        //http://api.yytianqi.com/weatherhours?city=CH180902&key=7ve6ubu725ecbt45
        return new Retrofit.Builder()
                .baseUrl("http://api.yytianqi.com/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    private static Retrofit getZTRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("http://222.141.17.79:7001/eGovaV14/dc/rest/query/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }
}
