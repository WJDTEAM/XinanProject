package tqm.bianfeng.com.xinanproject.network.api;

import retrofit2.http.GET;
import rx.Observable;
import tqm.bianfeng.com.xinanproject.network.url.TargetUrl;
import tqm.bianfeng.com.xinanproject.pojo.Weather;

/**
 * Created by johe on 2017/4/19.
 */

public interface WeatherService {

    @GET("weather?location=新安"+ TargetUrl.url2)
    Observable<Weather> getMyAttention();



}
