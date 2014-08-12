package com.webex.dataservice.util;

import com.webex.dataservice.service.IDataService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Kevin on 2014/7/7.
 */
public class DataServiceFactory{

    private static volatile DataServiceFactory factory;

    private ApplicationContext context;

    private DataServiceFactory() {
        context = new ClassPathXmlApplicationContext(new String[]{
                "classpath*:dataservice-service.xml",
//                "classpath*:/springbeans-biz-tx.xml",
                "classpath*:dataservice-dao.xml",
                "classpath*:dataservice-ds.xml"

        });
    }

    public static DataServiceFactory init() {
        if (factory == null) {
            synchronized (DataServiceFactory.class) {
                if (factory == null) {
                    factory = new DataServiceFactory();
                }
            }
        }
        return factory;
    }

    private ApplicationContext getContext() {
        return context;
    }

    public static IDataService getService() {
        return (IDataService) init().getContext().getBean("dataService");
    }
}
