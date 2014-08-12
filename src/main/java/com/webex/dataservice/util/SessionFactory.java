package com.webex.dataservice.util;

import com.datastax.driver.core.Session;

/**
 * Created by Kevin on 2014/7/7.
 */
public interface SessionFactory {
   public Session getSession();
}
