package com.webex.dataservice.support;

import com.webex.dataservice.dao.givr.IGlobalivrDao;
import com.webex.dataservice.dao.givr.rdbms.IGlobalivrRdbmsDao;
import com.webex.dataservice.service.dos.TeleConfLocationDO;
import com.webex.dataservice.service.IDataService;
import com.webex.dataservice.service.dos.MaccDO;
import com.webex.dataservice.service.dos.MaccdomainDO;

import java.util.Map;

/**
 * Created by Kevin on 2014/7/8.
 */
public class DataService implements IDataService {
    IGlobalivrDao globalivrDao;
    IGlobalivrRdbmsDao globalivrRdbmsDao;
    @Override
    public int registerMacc(MaccDO rqst) {
        globalivrDao.put("wbxtelemacc", rqst);
        return 0;
    }

    @Override
    public int unregisterMacc(String maccIndex) {
        globalivrDao.del("wbxtelemacc", "maccindex", maccIndex);
        return 0;
    }

    @Override
    public MaccDO getMaccURI(String maccIndex) {
        return (MaccDO) globalivrDao.get("wbxtelemacc", "maccindex", maccIndex);
    }

    @Override
    public Map<Integer, MaccdomainDO> getMaccIndexByAccessCode(String accessCode) {
        return globalivrRdbmsDao.selectMaccIndexByAccessCode(accessCode);
    }

    @Override
    public int registerMeeting(TeleConfLocationDO rqst) {
        globalivrDao.put("wbxteleconference", rqst);
        return 0;
    }

    @Override
    public int unregisterMeeting(String accessCode) {
        globalivrDao.del("wbxteleconference","accesscode",accessCode);
        return 0;
    }

    @Override
    public TeleConfLocationDO getMeetingLocation(String accessCode) {
        return (TeleConfLocationDO) globalivrDao.get("wbxteleconference", "accesscode",accessCode);
    }

    public IGlobalivrDao getGlobalivrDao() {
        return globalivrDao;
    }

    public void setGlobalivrDao(IGlobalivrDao globalivrDao) {
        this.globalivrDao = globalivrDao;
    }

    public IGlobalivrRdbmsDao getGlobalivrRdbmsDao() {
        return globalivrRdbmsDao;
    }

    public void setGlobalivrRdbmsDao(IGlobalivrRdbmsDao globalivrRdbmsDao) {
        this.globalivrRdbmsDao = globalivrRdbmsDao;
    }
}
