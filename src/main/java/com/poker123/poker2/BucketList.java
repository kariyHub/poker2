package com.poker123.poker2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BucketList {
    @Id
    @Column(name = "id", unique = false, nullable = false)
    private long id = 1;

    @Column(name = "reg", nullable = false)
    private String reg;

    @Column(name = "time1", nullable = false)
    private String time1;

    @Column(name = "time2", nullable = false)
    private String time2;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "pow", nullable = false)
    private int pow;


    BucketList() {

    }

    BucketList(String reg, String time1,
               String time2, String url, int pow) {
        this.reg = reg;
        this.time1 = time1;
        this.time2 = time2;
        this.url = url;
        this.pow = pow;
    }

    BucketList(long id, String reg, String time1, String time2,
               String url, int pow) {
        this.id = id;
        this.reg = reg;
        this.time1 = time1;
        this.time2 = time2;
        this.url = url;
        this.pow = pow;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    @Override
    public String toString() {
        return "BucketList{" +
                "id=" + id +
                ", reg='" + reg + '\'' +
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", url='" + url + '\'' +
                ", pow='" + pow + '\'' +
                '}';
    }
}
