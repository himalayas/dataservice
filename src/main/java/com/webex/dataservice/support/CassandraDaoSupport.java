package com.webex.dataservice.support;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.webex.dataservice.util.CqlUtil;
import com.webex.dataservice.util.SessionFactory;

/**
 * Created by Kevin on 2014/7/7.
 */
public class CassandraDaoSupport {
    private Session session;
    private String keyspace;
    private String w_cl;
    private String r_cl;
    public ResultSet insert(Object o,String table){
       return session.execute(CqlUtil.prepareInsert(o,keyspace,table,w_cl));
    }
    public ResultSet select(Object k,Object v,String table){
        return session.execute(CqlUtil.prepareQuery(k, v, keyspace, table,r_cl));
    }
    public ResultSet delete(Object k,Object v,String table){
       return session.execute(CqlUtil.prepareDelete(k, v, keyspace, table,w_cl));
    }

    public ResultSet update(Object o,String key,Object v,String table){
      return  session.execute(CqlUtil.prepareUpdate(o,key, v, keyspace, table,w_cl));
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setCassandraSessionFactory(SessionFactory cassandraSessionFactory) {
        this.session=cassandraSessionFactory.getSession();
    }

    public String getKeyspace() {
        return keyspace;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }

    public String getW_cl() {
        return w_cl;
    }

    public void setW_cl(String w_cl) {
        this.w_cl = w_cl;
    }

    public String getR_cl() {
        return r_cl;
    }

    public void setR_cl(String r_cl) {
        this.r_cl = r_cl;
    }
}
