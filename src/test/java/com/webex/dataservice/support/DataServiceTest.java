package com.webex.dataservice.support;

import com.webex.dataservice.JunitTestBase;
import com.webex.dataservice.service.dos.TeleConfLocationDO;
import com.webex.dataservice.service.IDataService;
import com.webex.dataservice.service.dos.MaccDO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class DataServiceTest extends JunitTestBase {
    @Autowired
    IDataService dataService;
    MaccDO maccDO;
    TeleConfLocationDO teleConfLocationDO;

    @Before
    public void setUp() throws Exception {
        logger.info("DataServiceTest.setUp...");
        maccDO = new MaccDO();
        maccDO.setRegistertime(new Date().getTime());
        maccDO.setMaccindex(String.valueOf(System.nanoTime()));
        maccDO.setMaccuris("www.baidu.com");
        maccDO.setApplastmodifiedtime(new Date().getTime());
        maccDO.setExpiretime(new Date().getTime());
        dataService.registerMacc(maccDO);

        teleConfLocationDO = new TeleConfLocationDO();
        teleConfLocationDO.setExpiretime(new Date().getTime());
        teleConfLocationDO.setTasuris("www.cisco.com");
        teleConfLocationDO.setAccesscode(String.valueOf(System.nanoTime()));
        teleConfLocationDO.setApplastmodifiedtime(new Date().getTime());
        teleConfLocationDO.setRegistertime(new Date().getTime());

        dataService.registerMeeting(teleConfLocationDO);

    }

    @Test
    public void testRegisterMacc() throws Exception {
        dataService.registerMacc(maccDO);
        assertEquals(dataService.getMaccURI(maccDO.getMaccindex()).getMaccindex(), maccDO.getMaccindex());
    }

    @Test
    public void testUnregisterMacc() throws Exception {
        dataService.unregisterMacc(maccDO.getMaccindex());
    }

    @Test
    public void testGetMaccURI() throws Exception {
        assertEquals(dataService.getMaccURI(maccDO.getMaccindex()).getMaccindex(), maccDO.getMaccindex());
    }

    @Test
    public void testGetMaccIndexByAccessCode() throws Exception {
        Map map=dataService.getMaccIndexByAccessCode("000000");
        assert map.size()==0;
    }

    @Test
    public void testRegisterMeeting() throws Exception {
        dataService.registerMeeting(teleConfLocationDO);
        assertEquals(dataService.getMeetingLocation(teleConfLocationDO.getAccesscode()).getAccesscode(), teleConfLocationDO.getAccesscode());
    }

    @Test
    public void testUnregisterMeeting() throws Exception {
        dataService.unregisterMeeting(teleConfLocationDO.getAccesscode());
        assertNull(dataService.getMeetingLocation(teleConfLocationDO.getAccesscode()));
    }

    @Test
    public void testGetMeetingLocation() throws Exception {
        assertNotNull(dataService.getMeetingLocation(teleConfLocationDO.getAccesscode()));
    }
}