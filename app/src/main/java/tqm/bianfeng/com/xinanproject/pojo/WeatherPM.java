package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/22.
 * {
 "code": 1,
 "msg": "Sucess",
 "counts": 19984,
 */

public class WeatherPM {
    int code;
    String msg;
    String counts;
    WeatherPMData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public WeatherPMData getData() {
        return data;
    }

    public void setData(WeatherPMData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherPM{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", counts='" + counts + '\'' +
                ", data=" + data +
                '}';
    }
}
