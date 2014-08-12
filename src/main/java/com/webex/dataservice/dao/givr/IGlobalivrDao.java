package com.webex.dataservice.dao.givr;

import com.webex.dataservice.service.dos.TeleConfLocationDO;
import com.webex.dataservice.service.dos.MaccDO;

/**
 * Created by Kevin on 2014/7/8.
 */
public interface IGlobalivrDao {
    public int put(String table,Object o);
    public int del(String table,String key,String value);
    public Object get(String table,String key,String value);
}
