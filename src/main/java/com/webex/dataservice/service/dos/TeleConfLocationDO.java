package com.webex.dataservice.service.dos;

import java.io.Serializable;

/**
 * Created by Kevin on 2014/7/8.
 * TeleConfLocation
 */
public class TeleConfLocationDO implements Serializable {
    private String accesscode; //text PRIMARY KEY,
    private long applastmodifiedtime;//bigint,
    private long expiretime;// bigint,
    private long registertime;// bigint,
    private String tasuris;// text
    private String seqnumber; // text

    public String getSeqnumber() {
		return seqnumber;
	}

	public void setSeqnumber(String seqnumber) {
		this.seqnumber = seqnumber;
	}

	public String getAccesscode() {
        return accesscode;
    }

    public TeleConfLocationDO() {
    }

    public TeleConfLocationDO(String accesscode, long applastmodifiedtime, long expiretime, long registertime, String tasuris, String seqnumber) {
        this.accesscode = accesscode;
        this.applastmodifiedtime = applastmodifiedtime;
        this.expiretime = expiretime;
        this.registertime = registertime;
        this.tasuris = tasuris;
        this.seqnumber = seqnumber;
    }

    public void setAccesscode(String accesscode) {
        this.accesscode = accesscode;
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

    public long getRegistertime() {
        return registertime;
    }

    public void setRegistertime(long registertime) {
        this.registertime = registertime;
    }

    public String getTasuris() {
        return tasuris;
    }

    public void setTasuris(String tasuris) {
        this.tasuris = tasuris;
    }
}
