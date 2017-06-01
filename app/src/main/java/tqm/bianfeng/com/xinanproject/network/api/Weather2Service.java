package tqm.bianfeng.com.xinanproject.network.api;

import retrofit2.http.GET;
import rx.Observable;
import tqm.bianfeng.com.xinanproject.pojo.Weather24;
import tqm.bianfeng.com.xinanproject.pojo.WeatherPM;

/**
 * Created by johe on 2017/4/19.
 */

public interface Weather2Service {

    @GET("weatherhours?city=CH180902&key=7ve6ubu725ecbt45")
    Observable<Weather24> getMyAttention();

    @GET("air?city=CH180901&key=7ve6ubu725ecbt45")
    Observable<WeatherPM> getPM();
}
