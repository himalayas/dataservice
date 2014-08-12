package com.webex.dataservice.service.dos;

import java.io.Serializable;

/**
 * Created by xiujguo on 14-7-11.
 */
public class MaccdomainDO implements Serializable {
    private String maccdomainindexid;
    private String maccdomainindex;
    private String primaryvip;
    private String backupvip;
    private int priority;

    public MaccdomainDO() {
    }

    public MaccdomainDO(String maccdomainindexid, String maccdomainindex, String primaryvip, String backupvip, int priority) {
        this.maccdomainindexid = maccdomainindexid;
        this.maccdomainindex = maccdomainindex;
        this.primaryvip = primaryvip;
        this.backupvip = backupvip;
        this.priority = priority;
    }

    public String getMaccdomainindexid() {
        return maccdomainindexid;
    }

    public void setMaccdomainindexid(String maccdomainindexid) {
        this.maccdomainindexid = maccdomainindexid;
    }

    public String getMaccdomainindex() {
        return maccdomainindex;
    }

    public void setMaccdomainindex(String maccdomainindex) {
        this.maccdomainindex = maccdomainindex;
    }

    public String getPrimaryvip() {
        return primaryvip;
    }

    public void setPrimaryvip(String primaryvip) {
        this.primaryvip = primaryvip;
    }

    public String getBackupvip() {
        return backupvip;
    }

    public void setBackupvip(String backupvip) {
        this.backupvip = backupvip;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
