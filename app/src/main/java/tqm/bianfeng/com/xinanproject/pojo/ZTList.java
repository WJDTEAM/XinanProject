package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/24.
 */

public class ZTList {
    /**
     * TIME : 2017-04-24 14:00:00
     * VALUE : 3
     * TYPE : NO2
     * NUM : 2
     */

    private String TIME;
    private int VALUE;
    private String TYPE;
    private int NUM;

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public int getVALUE() {
        return VALUE;
    }

    public void setVALUE(int VALUE) {
        this.VALUE = VALUE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int getNUM() {
        return NUM;
    }

    public void setNUM(int NUM) {
        this.NUM = NUM;
    }

    @Override
    public String toString() {
        return "ZTList{" +
                "TIME='" + TIME + '\'' +
                ", VALUE=" + VALUE +
                ", TYPE='" + TYPE + '\'' +
                ", NUM=" + NUM +
                '}';
    }
}
