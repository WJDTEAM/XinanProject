package tqm.bianfeng.com.xinanproject.pojo;

import java.util.List;

/**
 * Created by johe on 2017/4/21.
 *  "cityId": "CH180902",
 "cityName": "\u65b0\u5b89",
 "sj": "2017-04-21 15:00:00",
 "list": [
 */

public class Weather24Data {


    String cityId;
    String cityName;
    String sj;
    List<Weather24List> list;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public List<Weather24List> getList() {
        return list;
    }

    public void setList(List<Weather24List> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Weather24Data{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", sj='" + sj + '\'' +
                ", list=" + list +
                '}';
    }
}
