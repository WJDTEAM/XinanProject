package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/21.
 * "code": 1,
 "msg": "Sucess",
 "counts": 19993,
 "data": {
 */

public class Weather24 {
    int code;
    String msg;
    String counts;
    Weather24Data data;

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

    public Weather24Data getData() {
        return data;
    }

    public void setData(Weather24Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Weather24{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", counts='" + counts + '\'' +
                ", data=" + data +
                '}';
    }
}
