package com.webex.dataservice;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Think
 * Date: 13-10-29
 * Time: 下午10:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "classpath*:dataservice-ds.xml",
        "classpath*:dataservice-dao.xml",
        "classpath*:dataservice-service.xml"})
public class JunitTestBase extends AbstractJUnit4SpringContextTests {
}
