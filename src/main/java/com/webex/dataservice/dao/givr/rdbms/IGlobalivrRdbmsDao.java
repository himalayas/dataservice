package com.webex.dataservice.dao.givr.rdbms;

import com.webex.dataservice.service.dos.MaccdomainDO;

import java.util.Map;

/**
 * Created by xiujguo on 14-7-11.
 */
public interface IGlobalivrRdbmsDao {
    public Map<Integer, MaccdomainDO> selectMaccIndexByAccessCode(String accessCode);//from RDMS db
}
