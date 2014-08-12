package com.webex.dataservice.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kevin on 2014/7/7.
 */
public class SqlBaseDao extends SqlSessionDaoSupport{
    Logger daoLogger = LoggerFactory.getLogger(this.getClass());
}
