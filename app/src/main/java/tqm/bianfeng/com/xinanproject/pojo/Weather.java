package tqm.bianfeng.com.xinanproject.pojo;

import java.util.List;

/**
 * Created by johe on 2017/4/19.
 * "error": 0,
 "status": "success",
 "date": "2017-04-19",
 */

public class Weather {
    int error;
    String status;
    String date;
    private List<WeatherResults> results;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<WeatherResults> getResults() {
        return results;
    }

    public void setResults(List<WeatherResults> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "error=" + error +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", results=" + results +
                '}';
    }
}
