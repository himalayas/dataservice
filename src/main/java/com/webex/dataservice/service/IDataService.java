package com.webex.dataservice.service;

import com.webex.dataservice.service.dos.TeleConfLocationDO;
import com.webex.dataservice.service.dos.MaccDO;
import com.webex.dataservice.service.dos.MaccdomainDO;

import java.util.Map;

/**
 * Created by Kevin on 2014/7/7.
 */
public interface IDataService {
    public int registerMacc(MaccDO rqst);
    public int unregisterMacc(String maccIndex);
    public MaccDO getMaccURI(String maccIndex);
    public Map<Integer,MaccdomainDO> getMaccIndexByAccessCode(String accessCode);
    public int registerMeeting(TeleConfLocationDO rqst);
    public int unregisterMeeting(String accessCode);
    public TeleConfLocationDO getMeetingLocation(String accessCode);
}
