package tqm.bianfeng.com.xinanproject.pojo;

import java.util.List;

/**
 * Created by johe on 2017/4/19.
 * "currentCity": "洛阳市",
 "pm25": "112",
 */

public class WeatherResults {

    String currentCity;
    String pm25;

    List<WeatherIndex> index;
    List<WeatherData> weather_data;

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public List<WeatherIndex> getIndex() {
        return index;
    }

    public void setIndex(List<WeatherIndex> index) {
        this.index = index;
    }

    public List<WeatherData> getWeather_data() {
        return weather_data;
    }

    public void setWeather_data(List<WeatherData> weather_data) {
        this.weather_data = weather_data;
    }

    @Override
    public String toString() {
        return "WeatherResults{" +
                "currentCity='" + currentCity + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", index=" + index +
                ", weather_data=" + weather_data +
                '}';
    }
}
