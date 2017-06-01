package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/22.
 */

public class WeatherPMData {
    /**
     * city_id : CH010100
     * city_name : 北京
     * last_update : 2017-04-22 11:00:00
     * aqi : 85
     * pollutant : pm2.5
     * pm25 : 57
     * pm10 : 94
     * so2 : 7
     * no2 : 62
     * level : 二级
     * grade : 良
     * color : 黄色
     * health : 空气质量可接受，但某些污染物可能对极少数异常敏感人群健康有较弱影响
     * measure : 极少数异常敏感人群应减少户外活动
     */

    private String city_id;
    private String city_name;
    private String last_update;
    private String aqi;
    private String pollutant;
    private String pm25;
    private String pm10;
    private String so2;
    private String no2;
    private String level;
    private String grade;
    private String color;
    private String health;
    private String measure;

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "WeatherPMData{" +
                "city_id='" + city_id + '\'' +
                ", city_name='" + city_name + '\'' +
                ", last_update='" + last_update + '\'' +
                ", aqi='" + aqi + '\'' +
                ", pollutant='" + pollutant + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", so2='" + so2 + '\'' +
                ", no2='" + no2 + '\'' +
                ", level='" + level + '\'' +
                ", grade='" + grade + '\'' +
                ", color='" + color + '\'' +
                ", health='" + health + '\'' +
                ", measure='" + measure + '\'' +
                '}';
    }
}
