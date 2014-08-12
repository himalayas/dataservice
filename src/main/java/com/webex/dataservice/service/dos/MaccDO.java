package com.webex.dataservice.service.dos;

import java.io.Serializable;

/**
 * Created by Kevin on 2014/7/8.
 */
public class MaccDO implements Serializable {
    private String maccindex;// text PRIMARY KEY,
    private long applastmodifiedtime;// bigint,
    private long expiretime;// bigint,
    private String maccuris;// text,
    private long registertime;// bigint

    public String getMaccindex() {
        return maccindex;
    }

    public MaccDO() {
    }

    public MaccDO(String maccindex, long applastmodifiedtime, long expiretime, String maccuris, long registertime) {
        this.maccindex = maccindex;
        this.applastmodifiedtime = applastmodifiedtime;
        this.expiretime = expiretime;
        this.maccuris = maccuris;
        this.registertime = registertime;
    }

    public void setMaccindex(String maccindex) {
        this.maccindex = maccindex;
    }

    public long getApplastmodifiedtime() {
        return applastmodifiedtime;
    }

    public void setApplastmodifiedtime(long applastmodifiedtime) {
        this.applastmodifiedtime = applastmodifiedtime;
    }

    public long getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(long expiretime) {
        this.expiretime = expiretime;
    }

    public String getMaccuris() {
        return maccuris;
    }

    public void setMaccuris(String maccuris) {
        this.maccuris = maccuris;
    }

    public long getRegistertime() {
        return registertime;
    }

    public void setRegistertime(long registertime) {
        this.registertime = registertime;
    }
}
