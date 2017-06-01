package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/21.
 */

public class Weather24List {
    /**
     * tq : 晴
     * numtq : 00
     * qw : 23
     * sd : 19
     * sj : 2017-04-21 15:00:00
     */

    private String tq;
    private String numtq;
    private String qw;
    private String sd;
    private String sj;

    public String getTq() {
        return tq;
    }

    public void setTq(String tq) {
        this.tq = tq;
    }

    public String getNumtq() {
        return numtq;
    }

    public void setNumtq(String numtq) {
        this.numtq = numtq;
    }

    public String getQw() {
        return qw;
    }

    public void setQw(String qw) {
        this.qw = qw;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    @Override
    public String toString() {
        return "Weather24List{" +
                "tq='" + tq + '\'' +
                ", numtq='" + numtq + '\'' +
                ", qw='" + qw + '\'' +
                ", sd='" + sd + '\'' +
                ", sj='" + sj + '\'' +
                '}';
    }
}
