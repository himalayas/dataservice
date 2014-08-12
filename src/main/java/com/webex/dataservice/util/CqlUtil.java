package com.webex.dataservice.util;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.*;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Kevin on 2014/7/7.
 */
public class CqlUtil {
    public static   Insert prepareInsert(Object t, String keyspace, String table,String w_cl) {
        Insert insert = QueryBuilder.insertInto(keyspace, table);
        Class<?> c = t.getClass();
        try {
            for (Field f : c.getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(t) != null) {
                    switch (f.get(t).getClass().getSimpleName()) {
                        case TypeEnum.DATE:
                            insert.value(f.getName(), ((Date)f.get(t)).getTime());
                            break;
                        case TypeEnum.INT:
                            insert.value(f.getName(), f.getInt(t));
                            break;
                        case TypeEnum.STRING:
                            insert.value(f.getName(), f.get(t).toString());
                            break;
                        case TypeEnum.LONG:
                            insert.value(f.getName(), f.getLong(t));
                            break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        insert.setConsistencyLevel(ConsistencyLevel.valueOf(w_cl));
        return insert;
    }
    public static   Statement prepareQuery(Object id,Object value,String keyspace,String table,String r_cl){
        return QueryBuilder
                .select()
                .all()
                .from(keyspace, table)
                .where(QueryBuilder.eq(id.toString(), value)).setConsistencyLevel(ConsistencyLevel.valueOf(r_cl));

    }
    public static   Statement prepareDelete(Object id,Object value,String keyspace,String table,String w_cl){
        return QueryBuilder
                .delete()
                .all()
                .from(keyspace, table)
                .where(QueryBuilder.eq(id.toString(), value)).setConsistencyLevel(ConsistencyLevel.valueOf(w_cl));
    }
    public static   Statement prepareUpdate(Object id,String key,Object value,String keyspace,String table,String w_cl){
        return QueryBuilder
                .update(keyspace, table)
                .with(QueryBuilder.set(key, value))
                .where(QueryBuilder.eq(id.toString(), value)).setConsistencyLevel(ConsistencyLevel.valueOf(w_cl));
    }
}
