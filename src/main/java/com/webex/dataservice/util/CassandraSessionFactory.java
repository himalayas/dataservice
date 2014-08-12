package com.webex.dataservice.util;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;

/**
 * Created by Kevin on 2014/7/7.
 */
public class CassandraSessionFactory implements SessionFactory {
    private Cluster cluster;
    private CassandraSessionFactory(String nodes){
        PoolingOptions po=new PoolingOptions();
        po.setCoreConnectionsPerHost(HostDistance.LOCAL,2);
        po.setCoreConnectionsPerHost(HostDistance.REMOTE,1);
        cluster = Cluster.builder()
                .withReconnectionPolicy(new ConstantReconnectionPolicy(2000))
                .withPoolingOptions(po)
                .addContactPoints(nodes.split(","))
                .build();
    }
    public Session getSession() {
         return cluster.connect();
    }
    public void close() {
        cluster.close();
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
}
