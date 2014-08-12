package com.webex.dataservice.util;

import com.webex.dataservice.JunitTestBase;
import org.junit.Test;

import java.util.Date;

public class CqlUtilTest extends JunitTestBase {

    @Test
    public void testParse(){
        User u=new User();
        u.setAge(100);
        u.setBirthday(new Date());
        u.setMoney(1111111L);
        u.setName("xiujguo");
    }
}