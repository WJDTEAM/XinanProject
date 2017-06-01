package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/19.
 */

public class WeatherIndex {
    /**
     * title : 洗车
     * zs : 较适宜
     * tipt : 洗车指数
     * des : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
     */

    private String title;
    private String zs;
    private String tipt;
    private String des;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    public String getTipt() {
        return tipt;
    }

    public void setTipt(String tipt) {
        this.tipt = tipt;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "WeatherIndex{" +
                "title='" + title + '\'' +
                ", zs='" + zs + '\'' +
                ", tipt='" + tipt + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
