package com.webex.dataservice.dao;

import com.webex.dataservice.support.CassandraDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kevin on 2014/7/7.
 */
public class CqlBaseDao extends CassandraDaoSupport {
    Logger daoLogger = LoggerFactory.getLogger(this.getClass());
}
