package com.webex.dataservice.dao.givr;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.webex.dataservice.service.dos.TeleConfLocationDO;
import com.webex.dataservice.service.dos.MaccDO;
import com.webex.dataservice.support.CassandraDaoSupport;

/**
 * Created by Kevin on 2014/7/8.
 */
public class GlobalivrDao extends CassandraDaoSupport implements IGlobalivrDao {
    @Override
    public int put(String table, Object o) {
        insert(o, table);
        return 0;
    }

    @Override
    public int del(String table, String key, String value) {
        delete(key, value, table);
        return 0;
    }

    @Override
    public Object get(String table, String key, String value) {
        ResultSet rs = select(key, value, table);
        Row row = rs.one();
        if (row != null) {
            if ("wbxtelemacc".equals(table))
                return new MaccDO(row.getString("maccindex"),
                        row.getLong("applastmodifiedtime"),
                        row.getLong("expiretime"),
                        row.getString("maccuris"),
                        row.getLong("registertime"));
            else if ("wbxteleconference".equals(table)) {
                return new TeleConfLocationDO(row.getString("accesscode"),
                        row.getLong("applastmodifiedtime"),
                        row.getLong("expiretime"),
                        row.getLong("registertime"),
                        row.getString("tasuris"),
                        row.getString("seqnumber"));
            }
        }
        return null;
    }
}
